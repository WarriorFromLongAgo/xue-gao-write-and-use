package javatest.lang.threadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalTest {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " = threadLocal.get() 1 = " + threadLocal.get());
                    threadLocal.set("hello" + count.getAndIncrement());
                    System.out.println(Thread.currentThread().getName() + " = threadLocal.get() 2 = " + threadLocal.get());
                }
            });
        }

    }
}
