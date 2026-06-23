package io.maestro3.sdk.internal.concurrent;

import io.maestro3.sdk.exception.M3SdkException;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BooleanSupplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ScopedExecutorServiceFactoryTest {

    @Test
    public void registerScopeShouldThrowWhenScopeNull() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(1L, TimeUnit.SECONDS)) {
            assertThrows(IllegalArgumentException.class, () -> factory.registerScope(null, 1));
        }
    }

    @Test
    public void registerScopeShouldThrowWhenScopeBlank() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(1L, TimeUnit.SECONDS)) {
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> factory.registerScope("   ", 1));
            assertTrue(ex.getMessage().contains("Scope must not be null or empty"));
        }
    }

    @Test
    public void registerScopeShouldThrowWhenMaxTokensNonPositive() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(1L, TimeUnit.SECONDS)) {
            assertThrows(IllegalArgumentException.class, () -> factory.registerScope("scope", 0));
        }
    }

    @Test
    public void registerScopeShouldThrowWhenDurationThresholdNonPositive() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(1L, TimeUnit.SECONDS)) {
            assertThrows(IllegalArgumentException.class, () -> factory.registerScope("scope", 1, 0L, 10L));
        }
    }

    @Test
    public void registerScopeShouldIncreaseThreadPoolMaxSize() {
        try (ThreadPoolExecutor threadPool = newThreadPoolExecutor();
             ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(threadPool)) {
            register(factory, "scope1", 3);
            assertEquals(4, threadPool.getMaximumPoolSize());
        }
    }

    @Test
    public void scopedExecutorSubmitCallableShouldReturnResult() throws Exception {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            AtomicInteger counter = new AtomicInteger();
            Future<Integer> future = scoped.submit(() -> {
                counter.incrementAndGet();
                return 42;
            });

            assertEquals(Integer.valueOf(42), future.get(5, TimeUnit.SECONDS));
            assertEquals(1, counter.get());
        }
    }

    @Test
    public void scopedExecutorExecuteRunnableShouldRun() throws Exception {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            CountDownLatch latch = new CountDownLatch(1);
            scoped.execute(latch::countDown);
            assertTrue(latch.await(5, TimeUnit.SECONDS));
        }
    }

    @Test
    public void scopedExecutorShutdownNowShouldTerminateAndRemoveBucket() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            List<Runnable> pending = scoped.shutdownNow();
            assertTrue(pending.isEmpty());
            assertTrue(scoped.isShutdown());
            assertTrue(scoped.isTerminated());
            assertThrows(IllegalStateException.class, scoped::getCorePoolSize);
        }
    }

    @Test
    public void scopedExecutorShutdownShouldDelegateToShutdownNow() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            scoped.shutdown();
            assertTrue(scoped.isShutdown());
            assertTrue(scoped.isTerminated());
        }
    }

    @Test
    public void scopedExecutorAwaitTerminationReturnsFalse() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            assertFalse(scoped.awaitTermination(10, TimeUnit.MILLISECONDS));
        }
    }

    @Test
    public void cancelPotentiallyLeakedShouldThrowForUnknownScope() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor())) {
            assertThrows(IllegalArgumentException.class, () -> factory.cancelPotentiallyLeaked("unknown", 100L));
        }
    }

    @Test
    public void getTokenBucketsStatisticsShouldReturnRegisteredScope() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor())) {
            register(factory, "scope", 2);
            Map<String, TokenBucketStatistics> statistics = factory.getTokenBucketsStatistics();
            assertTrue(statistics.containsKey("scope"));
            TokenBucketStatistics bucketStats = statistics.get("scope");
            assertNotNull(bucketStats);
        }
    }

    @Test
    public void scopedExecutorWithUnregisteredScopeShouldThrowOnExecute() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor())) {
            ScopedExecutorServiceFactory.ScopedExecutorService scoped = new ScopedExecutorServiceFactory.ScopedExecutorService("ghost", factory);
            IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> scoped.execute(() -> {
            }));
            assertTrue(ex.getMessage().contains("Scope 'ghost' is not registered"));
        }
    }

    @Test
    public void toStringShouldIncludeThreadPoolMetrics() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(1L, TimeUnit.SECONDS)) {
            String description = factory.toString();
            assertTrue(description.contains("active count="));
        }
    }

    @Test
    public void scopedExecutorSetCorePoolSizeShouldUpdateTokenBucket() {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 2)) {
            assertEquals(2, scoped.getCorePoolSize());
            scoped.setCorePoolSize(3);
            assertEquals(3, scoped.getCorePoolSize());
            assertThrows(M3SdkException.class, () -> scoped.setCorePoolSize(0));
        }
    }

    @Test
    public void scopedExecutorIsInProgressReflectsRunningTasks() throws Exception {
        try (ScopedExecutorServiceFactory factory = new ScopedExecutorServiceFactory(newVirtualExecutor());
             ScopedExecutorServiceFactory.ScopedExecutorService scoped = register(factory, "scope", 1)) {
            assertFalse(scoped.isInProgress());

            CountDownLatch started = new CountDownLatch(1);
            CountDownLatch release = new CountDownLatch(1);

            Future<?> future = scoped.submit(() -> {
                started.countDown();
                release.await();
                return null;
            });

            assertTrue(started.await(5, TimeUnit.SECONDS));
            waitForCondition(scoped::isInProgress, 5, TimeUnit.SECONDS);

            release.countDown();
            future.get(5, TimeUnit.SECONDS);
            waitForCondition(() -> !scoped.isInProgress(), 5, TimeUnit.SECONDS);
        }
    }

    private ExecutorService newVirtualExecutor() {
        return Executors.newVirtualThreadPerTaskExecutor();
    }

    private ThreadPoolExecutor newThreadPoolExecutor() {
        return new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, new SynchronousQueue<>(), new MaestroThreadFactory("scoped", "-"));
    }

    private ScopedExecutorServiceFactory.ScopedExecutorService register(ScopedExecutorServiceFactory factory, String scope, int maxTokens) {
        return (ScopedExecutorServiceFactory.ScopedExecutorService) factory.registerScope(scope, maxTokens);
    }

    private void waitForCondition(BooleanSupplier condition, long timeout, TimeUnit unit) throws InterruptedException {
        CountDownLatch satisfied = new CountDownLatch(1);
        try (ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor()) {
            scheduler.scheduleAtFixedRate(() -> {
                if (condition.getAsBoolean()) {
                    satisfied.countDown();
                }
            }, 0, 1, TimeUnit.MILLISECONDS);

            if (!satisfied.await(timeout, unit)) {
                fail("Condition not satisfied within timeout");
            }
        }
    }
}
