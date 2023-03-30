package javatest.lang.inheritablethreadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class 线程池中traceid传递1 {

    // 最外层是main线程,设置了之后,传递不到线程池中的线程中

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        threadLocal.set("hello");

        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
            });
        }

    }
}
