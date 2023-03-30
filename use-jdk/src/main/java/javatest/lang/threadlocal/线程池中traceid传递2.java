package javatest.lang.threadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class 线程池中traceid传递2 {

    // 最外层是线程池1,设置了之后,传递不到线程池2中的线程中

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyArrayPoolExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<String> threadLocal = new ThreadLocal<>();
                    threadLocal.set("hello");

                    ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
                    for (int j = 0; j < 100; j++) {
                        threadPoolExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(threadLocal.get());
                            }
                        });
                    }
                }
            });
        }

        


    }
}
