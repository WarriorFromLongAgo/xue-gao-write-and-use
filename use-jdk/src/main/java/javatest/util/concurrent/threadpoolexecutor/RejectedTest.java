package javatest.util.concurrent.threadpoolexecutor;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class RejectedTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = MyThreadPool.getRejectedDiyInstance();
        // executor.setRejectedExecutionHandler((r, executor1) -> {
        //     System.out.println("拒绝策略");
        // });
        for (int i = 0; i < 10000; i++) {
            try {
                executor.execute(() -> {
                    System.out.println("manyInstance: " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (Exception e) {
                System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeee" + e);
            }
        }
    }



    private static void extracted() {
        ThreadPoolExecutor rejectedInstance = MyThreadPool.getRejectedInstance();

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            rejectedInstance.execute(() -> {
                System.out.println("rejectedInstance: " + Thread.currentThread().getName() + " i = " + finalI);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
