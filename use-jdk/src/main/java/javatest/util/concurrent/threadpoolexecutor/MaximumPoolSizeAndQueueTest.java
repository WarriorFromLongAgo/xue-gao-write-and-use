package javatest.util.concurrent.threadpoolexecutor;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MaximumPoolSizeAndQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = MyThreadPool.getManyManyArrayPoolExecutor();
        System.out.println("getQueue:" + executor.getQueue().size());

        extracted(executor);

        System.out.println("返回当前线程池中活动线程的数量:" + executor.getPoolSize());
        System.out.println("返回线程池的核心线程数:" + executor.getCorePoolSize());
        System.out.println("返回线程池的最大线程数:" + executor.getMaximumPoolSize());
        System.out.println("返回当前线程池中正在执行任务的线程数:" + executor.getActiveCount());
        System.out.println("返回线程池中曾经同时存在的最大线程数:" + executor.getLargestPoolSize());
        System.out.println("返回已完成的任务数:" + executor.getCompletedTaskCount());
        System.out.println("getQueue:" + executor.getQueue().size());
    }

    private static void extracted(ThreadPoolExecutor manyInstance) {
        for (int i = 0; i < 20; i++) {
            manyInstance.execute(() -> {
                System.out.println("manyInstance: " + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
