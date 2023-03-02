package javatest.lang.thread;

import java.util.concurrent.TimeUnit;

// 在一个线程控制另外一个线程，是失败的
public class 线程中断 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("1111 == 线程中断了 ");
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("线程休眠被中断，程序退出。");
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(10);
                    Thread.State state1 = thread1.getState();
                    System.out.println(" thread1 state 1 " + state1);
                    thread1.interrupt();
                    Thread.State state2 = thread1.getState();
                    System.out.println(" thread1 state 2 " + state2);
                } catch (Exception e) {
                    System.out.println(" 22222222222 " + e);
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }
}
