package com.alibaba.ttl.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import common.thread.MyThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class 线程池中traceid传递2 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyArrayPoolExecutor();
        ExecutorService ttlThreadPoolExecutor = TtlExecutors.getTtlExecutorService(threadPoolExecutor);
        AtomicInteger count = new AtomicInteger(0);

        for (int i = 0; i < 10; i++) {
            ttlThreadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();
                    threadLocal.set("hello" + count.getAndIncrement());

                    ThreadPoolExecutor threadPoolExecutorV2 = MyThreadPool.getManyManyListPoolExecutor();
                    ExecutorService ttlThreadPoolExecutorV2 = TtlExecutors.getTtlExecutorService(threadPoolExecutorV2);

                    for (int j = 0; j < 2; j++) {
                        ttlThreadPoolExecutorV2.execute(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
                            }
                        });
                    }
                }
            });
        }
    }
}
