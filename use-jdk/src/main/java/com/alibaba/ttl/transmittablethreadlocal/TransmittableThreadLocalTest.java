package com.alibaba.ttl.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import common.thread.MyThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class TransmittableThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        ExecutorService ttlThreadPoolExecutor = TtlExecutors.getTtlExecutorService(threadPoolExecutor);

        // testExecute(threadLocal, threadPoolExecutor);
        // System.out.println("=======================================================");
        // System.out.println("=======================================================");
        // System.out.println("=======================================================");
        testExecute(threadLocal, ttlThreadPoolExecutor);
    }

    private static void testExecute(ThreadLocal<String> threadLocal, ExecutorService threadPoolExecutor) {
        AtomicInteger count = new AtomicInteger(0);
        threadLocal.set("hello" + count.getAndIncrement());

        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = threadLocal.get() 1 = " + threadLocal.get());
                    System.out.println(Thread.currentThread().getName() + " = threadLocal.get() 2 = " + threadLocal.get());
                }
            });
        }
    }
}
