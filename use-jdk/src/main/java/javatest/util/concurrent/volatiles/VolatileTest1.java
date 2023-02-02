package javatest.util.concurrent.volatiles;

import java.util.concurrent.atomic.AtomicLong;

public class VolatileTest1 {

    private static final AtomicLong THREAD1_COUNT = new AtomicLong(0);
    private static final AtomicLong THREAD2_COUNT = new AtomicLong(0);

    // static 变量 i
    static volatile Integer i = 0;

    public static void main(String[] args) throws Exception {

        // 线程 1
        Thread thread1 = new Thread(() -> {
            synchronized (i) {
                try {

                    i = 1;
                    Thread.sleep(100);
                    THREAD1_COUNT.incrementAndGet();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 线程 2
        Thread thread2 = new Thread(() -> {
            synchronized (i) {
                try {

                    i = 2;
                    Thread.sleep(100);
                    if (i == 1) {
                        System.out.println("1"); // 实际运行结果为 1
                        System.out.println("thread1 运行次数" + THREAD1_COUNT.get());
                        System.out.println("thread2 运行次数" + THREAD2_COUNT.get());
                    }
                    THREAD2_COUNT.incrementAndGet();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // 不断运行线程 1 和 2
        while (true) {
            new Thread(thread1).start();
            new Thread(thread2).start();
        }
    }
}
