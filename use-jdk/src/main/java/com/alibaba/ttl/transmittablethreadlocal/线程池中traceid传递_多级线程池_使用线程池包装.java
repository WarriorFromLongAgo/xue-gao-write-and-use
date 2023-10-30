package com.alibaba.ttl.transmittablethreadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;
import common.thread.MyThreadPool;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 加入不适用包装类，那么就会产生traceid的混乱
 */
public class 线程池中traceid传递_多级线程池_使用线程池包装 {
    public static void main(String[] args) {
        // 注意，这里是两个线程池
        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        ExecutorService ttlExecutorService = TtlExecutors.getTtlExecutorService(threadPoolExecutor);
        TransmittableThreadLocal<String> threadLocal = new TransmittableThreadLocal<>();

        AtomicInteger atomicInteger = new AtomicInteger(0);

        for (; atomicInteger.get() < 10; atomicInteger.incrementAndGet()) {
            // 在这里设置，模拟有10个外部请求进来
            ttlExecutorService.execute(() -> {
                // 进来的瞬间，设置 traceid
                threadLocal.set("hello===" + UUID.randomUUID());
                yonghu_qingqiu(threadLocal, atomicInteger);
                // 出去的时候，删除 traceid
                threadLocal.remove();
            });
        }
    }

    /**
     * 用户请求
     */
    private static void yonghu_qingqiu(TransmittableThreadLocal<String> threadLocal, AtomicInteger atomicInteger) {
        // 在刚进来的请求里面，打印traceid
        System.out.println("i" + atomicInteger.get() + " === " + Thread.currentThread().getName() + " === " + threadLocal.get());

        // 这里是模拟，一次请求里面，使用线程池处理问题
        // 注意，这里是两个线程池
        ThreadPoolExecutor threadPoolExecutorV2 = MyThreadPool.getManyManyListPoolExecutor();
        ExecutorService ttlExecutorServiceV2 = TtlExecutors.getTtlExecutorService(threadPoolExecutorV2);
        for (int j = 0; j < 3; j++) {
            ttlExecutorServiceV2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
                }
            });
        }
    }
}
