package javatest.lang.threadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class 线程池中traceid传递1 {

    // 最外层是main线程,设置了之后,传递不到线程池中的线程中

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("hello");

        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                System.out.println(threadLocal.get());
            });
        }

    }
}
