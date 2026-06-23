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

import io.maestro3.sdk.internal.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ScopedExecutorServiceFactory implements AutoCloseable {

    private final Map<String, TokenBucket> tokenBuckets = new ConcurrentHashMap<>();
    private final ExecutorService tasksExecutor;
    private final ExecutorService tokenAcquisitionExecutor = Executors.newSingleThreadExecutor();
    private final UniqueBlockingQueue<String> completedScopes = new UniqueBlockingQueue<>();

    public ScopedExecutorServiceFactory(long keepAliveTime, TimeUnit unit) {
        this(new ThreadPoolExecutor(1, 1, keepAliveTime, unit,
            new SynchronousQueue<>(), new MaestroThreadFactory("scoped", "-")));
    }

    public ScopedExecutorServiceFactory(ExecutorService tasksExecutor) {
        this.tasksExecutor = tasksExecutor;
        consumeExecutedTasks();
    }

    public Map<String, TokenBucketStatistics> getTokenBucketsStatistics() {
        return tokenBuckets.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> {
            TokenBucket tokenBucket = e.getValue();
            tokenBucket.refill();
            return new TokenBucketStatistics(e.getValue().getMaxTokens(), e.getValue().getStatistics());
        }));
    }

    private void consumeExecutedTasks() {
        tokenAcquisitionExecutor.execute(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String scope = completedScopes.take();
                    Optional.ofNullable(tokenBuckets.get(scope)).ifPresent(TokenBucket::processTasks);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }

    private void increaseCore(int amount) {
        if (amount != 0 && tasksExecutor instanceof ThreadPoolExecutor executor) {
            executor.setMaximumPoolSize(executor.getMaximumPoolSize() + amount);
        }
    }

    public ExecutorService registerScope(String scope, int maxTokens) {
        return registerScope(scope, maxTokens, TokenBucket.DEFAULT_DURATION_THRESHOLD_MILLIS, TokenBucket.DEFAULT_MAX_QUEUE_SIZE);
    }

    public ExecutorService registerScope(String scope, int maxTokens, long durationThresholdMillis, long maxQueueSize) {
        if (scope == null || scope.isBlank()) {
            throw new IllegalArgumentException("Scope must not be null or empty");
        }
        if (maxTokens < 1) {
            throw new IllegalArgumentException("maxTokens must be > 0");
        }
        if (durationThresholdMillis < 1) {
            throw new IllegalArgumentException("durationThresholdMillis must be > 0");
        }
        tokenBuckets.computeIfAbsent(scope, bucket -> new TokenBucket(tasksExecutor, completedScopes, scope, maxTokens, durationThresholdMillis, maxQueueSize));
        increaseCore(maxTokens);
        return new ScopedExecutorService(scope, this);
    }

    private void submitTask(String scope, Supplier<?> task) {
        if (task == null) {
            throw new IllegalArgumentException("Task must not be null");
        }
        assertScopeExists(scope);
        tokenBuckets.get(scope).submitTask(task);
    }

    private void assertScopeExists(String scope) {
        if (scope == null || scope.isBlank()) {
            throw new IllegalArgumentException("Scope must not be null or empty");
        }
        if (!tokenBuckets.containsKey(scope)) {
            throw new IllegalArgumentException(String.format("Scope '%s' is not registered", scope));
        }
    }

    private void execute(Runnable command) {
        if (command == null) {
            throw new IllegalArgumentException("Command must not be null");
        }
        if (!(command instanceof ScopedExecutorService.QueueingFuture<?> scopedCommand)) {
            throw new IllegalArgumentException("Command must be of type ScopedExecutor.QueueingFuture");
        }

        submitTask(scopedCommand.scope, () -> {
            command.run();
            return null;
        });
    }

    public int cancelPotentiallyLeaked(String scope, long durationThresholdMillis) {
        assertScopeExists(scope);
        TokenBucket tokenBucket = tokenBuckets.get(scope);
        return tokenBucket.cancelPotentiallyLeaked(durationThresholdMillis);
    }

    @Override
    public void close() {
        tokenAcquisitionExecutor.shutdownNow();
        tasksExecutor.close();
    }

    @Override
    public String toString() {
        if (tasksExecutor instanceof ThreadPoolExecutor executor) {
            return String.format("active count=%s, current pool size=%s, largest pool size=%s, total threads created since startup=%s",
                executor.getActiveCount(), executor.getPoolSize(), executor.getLargestPoolSize(),
                MaestroThreadFactory.getThreadsCount());
        } else {
            return tasksExecutor.getClass().getSimpleName();
        }
    }

    public static class ScopedExecutorService extends AbstractExecutorService implements ExecutorService {
        private final String scope;
        private final ScopedExecutorServiceFactory executor;
        private final AtomicBoolean terminated = new AtomicBoolean(false);

        private static class QueueingFuture<V> extends FutureTask<V> {

            private final String scope;

            QueueingFuture(Callable<V> callable,
                           String scope) {
                super(callable);
                this.scope = scope;
            }

            QueueingFuture(Runnable runnable,
                           V result,
                           String scope) {
                super(runnable, result);
                this.scope = scope;
            }
        }

        public ScopedExecutorService(String scope, ScopedExecutorServiceFactory executor) {
            this.scope = scope;
            this.executor = executor;
        }

        @Override
        protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            return new QueueingFuture<>(runnable, value, scope);
        }

        @Override
        protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
            return new QueueingFuture<>(callable, scope);
        }

        @Override
        public void execute(Runnable command) {
            if (command instanceof QueueingFuture) {
                executor.execute(command);
            } else {
                executor.execute(new QueueingFuture<>(command, Void.class, scope));
            }
        }

        @Override
        public void shutdown() {
            shutdownNow();
        }

        @Override
        public List<Runnable> shutdownNow() {
            if (isTerminated()) {
                return List.of();
            }
            terminated.set(true);
            TokenBucket tokenBucket = executor.tokenBuckets.remove(scope);
            return tokenBucket.cancelAll();
        }

        @Override
        public boolean isShutdown() {
            return isTerminated();
        }

        @Override
        public boolean isTerminated() {
            return terminated.get();
        }

        @Override
        public boolean awaitTermination(long timeout, TimeUnit unit) {
            return terminated.get();
        }

        public int getCorePoolSize() {
            TokenBucket tokenBucket = getTokenBucket();
            return tokenBucket.getMaxTokens();
        }

        public void setCorePoolSize(int corePoolSize) {
            Assert.isPositive(corePoolSize, "corePoolSize");
            TokenBucket tokenBucket = getTokenBucket();
            tokenBucket.setMaxTokens(corePoolSize);
        }

        public boolean isInProgress() {
            TokenBucket tokenBucket = getTokenBucket();
            TokenBucket.BucketStatistics statistics = tokenBucket.getStatistics();
            return statistics.getStillRunningTasksCnt() != 0;
        }

        private TokenBucket getTokenBucket() {
            TokenBucket tokenBucket = executor.tokenBuckets.get(scope);
            if (tokenBucket == null) {
                throw new IllegalStateException("Executor already terminated");
            }
            tokenBucket.refill();
            return tokenBucket;
        }
    }
}
