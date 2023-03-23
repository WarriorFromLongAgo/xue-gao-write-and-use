package common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    private static final AtomicInteger COUNT = new AtomicInteger();

    private static final ThreadPoolExecutor ONE_ONE_LIST_POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolOne" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getOneOneListPoolExecutor() {
        return ONE_ONE_LIST_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor MANY_MANY_LIST_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolBusiness" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getManyManyListPoolExecutor() {
        return MANY_MANY_LIST_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor ONE_ONE_ARRAY_POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPoolOne" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getOneOneArrayPoolExecutor() {
        return ONE_ONE_ARRAY_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor MANY_MANY_ARRAY_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPoolBusiness" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getManyManyArrayPoolExecutor() {
        return MANY_MANY_ARRAY_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor REJECTED_POOL_EXECUTOR = new ThreadPoolExecutor(
            5,
            10,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPool rejected" + COUNT.incrementAndGet()),
            new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor getRejectedInstance() {
        return REJECTED_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor REJECTED_DIY_POOL_EXECUTOR = new ThreadPoolExecutor(
            5,
            10,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPool rejected" + COUNT.incrementAndGet()),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("rejectedExecution: " + Thread.currentThread().getName());
                    throw new RuntimeException("rejectedExecution");
                }
            });

    public static ThreadPoolExecutor getRejectedDiyInstance() {
        return REJECTED_DIY_POOL_EXECUTOR;
    }
}
