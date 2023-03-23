package javatest.util.concurrent.threadpoolexecutor;

import common.thread.MyThreadPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class DealExcepution {

    public static void main(String[] args) {
        // oneThreadTestV1_execute_Normal();
        // oneThreadTestV1_execute_Error();
        // oneThreadTestV2_execute_Error();

        oneThreadTestV1_submit_Error();

    }

    private static void oneThreadTestV1_execute_Normal() {
        IntStream
                .range(1, 5)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        MyThreadPool.getOneOneListPoolExecutor().execute(() -> {
                            System.out.println("oneThreadTestV1_Normal: " + Thread.currentThread().getName() + " value === " + value);
                        });
                    }
                });
        // oneThreadTestV1_Normal: ThreadPoolOne1 value === 1
        // oneThreadTestV1_Normal: ThreadPoolOne1 value === 2
        // oneThreadTestV1_Normal: ThreadPoolOne1 value === 3
        // oneThreadTestV1_Normal: ThreadPoolOne1 value === 4
        // 正常情况下，线程是可以复用的
    }

    public static void oneThreadTestV1_execute_Error() {
        IntStream
                .range(1, 5)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MyThreadPool.getOneOneListPoolExecutor().execute(() -> {
                            int j = 1 / 0;
                        });
                    }
                });
        // Exception in thread "ThreadPoolOne1" java.lang.ArithmeticException: / by zero
        // Exception in thread "ThreadPoolOne2" java.lang.ArithmeticException: / by zero
        // Exception in thread "ThreadPoolOne3" java.lang.ArithmeticException: / by zero
        // Exception in thread "ThreadPoolOne4" java.lang.ArithmeticException: / by zero
        // 测试未捕获异常
        // 可见每次执行的线程都不一样，之前的线程都没有复用。原因是因为出现了未捕获的异常。
    }

    public static void oneThreadTestV2_execute_Error() {
        IntStream
                .range(1, 5)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        MyThreadPool.getOneOneListPoolExecutor().execute(() -> {
                            try {
                                int j = 1 / 0;
                            } catch (Exception e) {
                                System.out.println(Thread.currentThread().getName() + " " + e.getMessage());
                            }
                        });
                    }
                });
        // ThreadPoolOne5 / by zero
        // ThreadPoolOne5 / by zero
        // ThreadPoolOne5 / by zero
        // ThreadPoolOne5 / by zero
    }

    public static void oneThreadTestV1_submit_Error() {
        IntStream
                .range(1, 5)
                .forEach(new IntConsumer() {
                    @Override
                    public void accept(int value) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        Future<?> submit = MyThreadPool.getOneOneListPoolExecutor().submit(() -> {
                            System.out.println("线程" + Thread.currentThread().getName() + "执行");
                            int j = 1 / 0;
                        });
                        try {
                            submit.get();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                });
        // 线程ThreadPoolOne1执行
        // 线程ThreadPoolOne1执行
        // 线程ThreadPoolOne1执行
        // 线程ThreadPoolOne1执行
        // 1、线程池中线程中异常尽量手动捕获
        // 2、通过设置ThreadFactory的UncaughtExceptionHandler可以对未捕获的异常做保底处理，通过execute提交任务，线程依然会中断，
        // 而通过submit提交任务，可以获取线程执行结果，线程异常会在get执行结果时抛出。
    }
}
