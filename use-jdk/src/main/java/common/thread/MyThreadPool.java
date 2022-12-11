package common.thread;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    private static final AtomicInteger COUNT = new AtomicInteger();

    private static final ThreadPoolExecutor ONE_POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolOne" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getOneInstance() {
        return ONE_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor MANY_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPoolBusiness" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getManyInstance() {
        return MANY_POOL_EXECUTOR;
    }
}
