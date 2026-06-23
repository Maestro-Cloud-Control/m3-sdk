/*
 * Copyright 2025 Maestro Cloud Control LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.maestro3.sdk.internal.concurrent;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

class TokenBucket {
    public static final long DEFAULT_DURATION_THRESHOLD_MILLIS = 5 * 60 * 1000L;
    public static final long DEFAULT_MAX_QUEUE_SIZE = Long.parseLong(System.getenv().getOrDefault("SCOPED_EXECUTOR_SERVICE_DEFAULT_MAX_QUEUE_SIZE", "1000"));

    private final AtomicInteger maxTokens;
    private final AtomicInteger availableTokens;
    private final ReentrantLock lock;
    private final ConcurrentLinkedQueue<Supplier<?>> pendingTasks = new ConcurrentLinkedQueue<>();
    private final Map<String, TimedTask<?>> runningTasks = new ConcurrentHashMap<>();
    private final UniqueBlockingQueue<String> completedScopes;
    private final BucketStatistics statistics = new BucketStatistics();
    private final long durationThresholdMillis;
    private final long maxQueueSize;
    private final String scope;
    private final ExecutorService executorService;

    TokenBucket(ExecutorService executorService, UniqueBlockingQueue<String> completedScopes, String scope, int maxTokens, long durationThresholdMillis, long maxQueueSize) {
        this.executorService = executorService;
        this.completedScopes = completedScopes;
        this.scope = scope;
        this.maxTokens = new AtomicInteger(maxTokens);
        this.availableTokens = new AtomicInteger(maxTokens);
        this.lock = new ReentrantLock();
        this.durationThresholdMillis = durationThresholdMillis > 0 ? durationThresholdMillis : DEFAULT_DURATION_THRESHOLD_MILLIS;
        this.maxQueueSize = maxQueueSize > 0 ? maxQueueSize : DEFAULT_MAX_QUEUE_SIZE;
    }

    int getMaxTokens() {
        return maxTokens.get();
    }

    void setMaxTokens(int maxTokens) {
        this.maxTokens.set(maxTokens);
    }

    void processTasks() {
        lock.lock();
        try {
            processTasksInternal();
        } finally {
            lock.unlock();
        }
    }

    private void processTasksInternal() {
        Supplier<?> task;
        while ((task = pendingTasks.peek()) != null) {
            TimedTask<?> timedTask = acquireToken(task);// Submit to thread pool only when token is acquired
            if (timedTask != null) {
                pendingTasks.poll(); // remove only when task is submitted
            } else {
                break; // task is not submitted, need to break
            }
        }
    }

    private <T> TimedTask<T> acquireToken(Supplier<T> supplier) {
        if (availableTokens.get() <= 0) {
            return null;
        }
        try {
            availableTokens.decrementAndGet();
            TimedSupplier<T> timedSupplier = new TimedSupplier<>(this, supplier);
            TimedTask<T> timedTask = new TimedTask<>(timedSupplier, CompletableFuture.supplyAsync(timedSupplier, executorService));
            statistics.increaseTotalSubmitted();
            runningTasks.put(timedSupplier.getUuid(), timedTask);
            return timedTask;
        } catch (Exception ex) {
            availableTokens.incrementAndGet();
            return null;
        }
    }

    void refill() {
        lock.lock();
        try {
            refillInternal();
        } finally {
            lock.unlock();
        }
    }

    private void refillInternal() {
        int potentiallyLeaked = 0;
        int stillRunning = 0;
        long currentDuration;
        long now = System.currentTimeMillis();
        for (TimedTask<?> rt : runningTasks.values()) {
            if (rt.getFuture().isDone()) {
                statistics.update(rt.getTimedSupplier().getDuration());
            } else {
                stillRunning++;
                currentDuration = now - rt.getTimedSupplier().getStartedTimestamp();
                if (statistics.getMaxDuration() > 0 && currentDuration > statistics.getMaxDuration() || currentDuration > durationThresholdMillis) {
                    potentiallyLeaked++;
                }
            }
        }
        statistics.setStillRunningTasksCnt(stillRunning);
        statistics.setPotentiallyLeaked(potentiallyLeaked);
    }

    private <T> void finishTask(TimedSupplier<T> timedSupplier) {
        lock.lock();
        try {
            runningTasks.remove(timedSupplier.getUuid());
            statistics.update(timedSupplier.getDuration());
            availableTokens.incrementAndGet();
            completedScopes.add(scope);
        } finally {
            lock.unlock();
        }
    }

    public int cancelPotentiallyLeaked(long durationThresholdMillis) {
        long now = System.currentTimeMillis();
        long currentDuration;
        int canceled = 0;
        for (TimedTask<?> rt : runningTasks.values()) {
            if (!rt.getFuture().isDone()) {
                currentDuration = now - rt.getTimedSupplier().getStartedTimestamp();
                if (currentDuration > durationThresholdMillis) {
                    canceled = rt.getFuture().cancel(true) ? canceled + 1 : canceled;
                }
            }
        }
        return canceled;
    }

    public List<Runnable> cancelAll() {
        for (TimedTask<?> rt : runningTasks.values()) {
            if (!rt.getFuture().isDone()) {
                rt.getFuture().cancel(true);
            }
        }
        runningTasks.clear();
        pendingTasks.clear();
        return List.of(); // try to extract Runnable from TimedTask
    }

    public BucketStatistics getStatistics() {
        return statistics;
    }

    @Override
    public String toString() {
        return "TokenBucket{" +
            "statistics=" + statistics +
            '}';
    }

    public void submitTask(Supplier<?> task) {
        lock.lock();
        try {
            if (pendingTasks.size() > maxQueueSize) {
                throw new RejectedExecutionException();
            }
            pendingTasks.add(task);
            processTasksInternal();
        } finally {
            lock.unlock();
        }
    }

    private static class TimedSupplier<T> implements Supplier<T> {
        private long startedTimestamp;
        private long endedTimestamp;
        private final String uuid;
        private final Supplier<T> origin;
        private final TokenBucket tokenBucket;

        public TimedSupplier(TokenBucket tokenBucket, Supplier<T> origin) {
            this.uuid = UUID.randomUUID().toString();
            this.tokenBucket = tokenBucket;
            this.origin = origin;
        }

        public String getUuid() {
            return uuid;
        }

        public long getStartedTimestamp() {
            return startedTimestamp;
        }

        public long getEndedTimestamp() {
            return endedTimestamp;
        }

        public long getDuration() {
            return endedTimestamp - startedTimestamp;
        }

        @Override
        public T get() {
            Thread currentThread = Thread.currentThread();
            String prefix = currentThread.isVirtual() ? currentThread.toString() : currentThread.getName();
            startedTimestamp = System.currentTimeMillis();
            T result;
            try {
                currentThread.setName(prefix + ":" + tokenBucket.scope);
                result = origin.get();
            } finally {
                currentThread.setName(prefix);
            }
            endedTimestamp = System.currentTimeMillis();
            tokenBucket.finishTask(this);
            return result;
        }

        @Override
        public String toString() {
            return "TimedSupplier{" +
                "startedTimestamp=" + startedTimestamp +
                ", endedTimestamp=" + endedTimestamp +
                ", duration=" + getDuration() +
                '}';
        }
    }

    private static class TimedTask<T> {
        private final TimedSupplier<T> timedSupplier;
        private final CompletableFuture<T> future;

        public TimedTask(TimedSupplier<T> timedSupplier, CompletableFuture<T> future) {
            this.timedSupplier = timedSupplier;
            this.future = future;
        }

        public TimedSupplier<T> getTimedSupplier() {
            return timedSupplier;
        }

        public CompletableFuture<T> getFuture() {
            return future;
        }
    }

    public static class BucketStatistics {
        private long totalSubmittedTasksCnt;
        private long stillRunningTasksCnt;
        private long totalFinishedTasksCnt;
        private long totalTasksDuration;
        private long minDuration = Long.MAX_VALUE;
        private long maxDuration = Long.MIN_VALUE;
        private long potentiallyLeaked;

        public void update(long duration) {
            totalFinishedTasksCnt++;
            if (duration < 0) {
                return;
            }
            totalTasksDuration += duration;
            if (duration < minDuration) {
                minDuration = duration;
            }
            if (duration > maxDuration) {
                maxDuration = duration;
            }
        }

        public void setStillRunningTasksCnt(long stillRunningTasksCnt) {
            this.stillRunningTasksCnt = stillRunningTasksCnt;
        }

        public long getTotalSubmittedTasksCnt() {
            return totalSubmittedTasksCnt;
        }

        public long getStillRunningTasksCnt() {
            return stillRunningTasksCnt;
        }

        public long getTotalFinishedTasksCnt() {
            return totalFinishedTasksCnt;
        }

        public long getTotalTasksDuration() {
            return totalTasksDuration;
        }

        public long getAvgDuration() {
            if (totalFinishedTasksCnt == 0) {
                return 0;
            }
            return totalTasksDuration / totalFinishedTasksCnt;
        }

        public long getMinDuration() {
            return minDuration;
        }

        public long getMaxDuration() {
            return maxDuration;
        }

        public void increaseTotalSubmitted() {
            totalSubmittedTasksCnt++;
        }

        public void setPotentiallyLeaked(int potentiallyLeaked) {
            this.potentiallyLeaked = potentiallyLeaked;
        }

        public long getPotentiallyLeaked() {
            return potentiallyLeaked;
        }

        @Override
        public String toString() {
            return "BucketStatistics{" +
                "totalSubmittedTasksCnt=" + totalSubmittedTasksCnt +
                ", stillRunningTasksCnt=" + stillRunningTasksCnt +
                ", potentiallyLeaked=" + potentiallyLeaked +
                ", totalFinishedTasksCnt=" + totalFinishedTasksCnt +
                ", totalTasksDuration=" + totalTasksDuration +
                ", avgDuration=" + getAvgDuration() +
                ", minDuration=" + minDuration +
                ", maxDuration=" + maxDuration +
                '}';
        }
    }
}
