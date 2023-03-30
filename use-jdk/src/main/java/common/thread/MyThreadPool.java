package common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPool {
    private static final AtomicInteger COUNT = new AtomicInteger(0);

    private static final ThreadPoolExecutor ONE_ONE_LIST_POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPool-one_one_list-" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getOneOneListPoolExecutor() {
        return ONE_ONE_LIST_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor MANY_MANY_LIST_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.LinkedBlockingQueue<>(),
            r -> new Thread(r, "ThreadPool-many_many_list-" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getManyManyListPoolExecutor() {
        return MANY_MANY_LIST_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor ONE_ONE_ARRAY_POOL_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPool-one_one_array-" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getOneOneArrayPoolExecutor() {
        return ONE_ONE_ARRAY_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor MANY_MANY_ARRAY_POOL_EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new java.util.concurrent.ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPool-many_many_array-" + COUNT.incrementAndGet()));

    public static ThreadPoolExecutor getManyManyArrayPoolExecutor() {
        return MANY_MANY_ARRAY_POOL_EXECUTOR;
    }

    private static final ThreadPoolExecutor REJECTED_POOL_EXECUTOR = new ThreadPoolExecutor(
            5,
            10,
            1L,
            java.util.concurrent.TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            r -> new Thread(r, "ThreadPool-rejected-AbortPolicy-" + COUNT.incrementAndGet()),
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
            r -> new Thread(r, "ThreadPool-rejected-diy-" + COUNT.incrementAndGet()),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    // System.out.println("自定义拒绝策略");
                    // 线程池不够用了 让用户等会再试试
                    System.out.println("rejectedExecution: " + Thread.currentThread().getName());
                    throw new RuntimeException("rejectedExecution");
                }
            });

    public static ThreadPoolExecutor getRejectedDiyInstance() {
        return REJECTED_DIY_POOL_EXECUTOR;
    }

    public static void printPoolInfo(ThreadPoolExecutor executor) {
        System.out.println("=========================================");
        System.out.println("getQueue:" + executor.getQueue().size());
        System.out.println("返回当前线程池中活动线程的数量:" + executor.getPoolSize());
        System.out.println("返回线程池的核心线程数:" + executor.getCorePoolSize());
        System.out.println("返回线程池的最大线程数:" + executor.getMaximumPoolSize());
        System.out.println("返回当前线程池中正在执行任务的线程数:" + executor.getActiveCount());
        System.out.println("返回线程池中曾经同时存在的最大线程数:" + executor.getLargestPoolSize());
        System.out.println("返回已完成的任务数:" + executor.getCompletedTaskCount());
        System.out.println("getQueue:" + executor.getQueue().size());
        System.out.println("=========================================");
    }
}
