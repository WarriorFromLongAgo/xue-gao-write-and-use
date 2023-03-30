package com.alibaba.ttl.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import common.thread.MyThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class 线程池中traceid传递1 {

    // 最外层是main线程,设置了之后,传递不到线程池中的线程中

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
        threadLocal.set("hello");

        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        ExecutorService ttlThreadPoolExecutor = TtlExecutors.getTtlExecutorService(threadPoolExecutor);
        for (int i = 0; i < 10; i++) {
            ttlThreadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
            });
        }

    }
}
