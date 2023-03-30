package javatest.lang.inheritablethreadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class 问题1_实现2 {
    public static void main(String[] args) throws InterruptedException {
        // 当InheritableThreadLocal遇到线程池：主线程本地变量修改后，子线程无法读取到新值
        // 注意: 建议使用长度为1的线程池测试,确保是同一个Thread
        ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
        ThreadPoolExecutor executor = MyThreadPool.getOneOneArrayPoolExecutor();

        System.out.println("主线程开启");
        threadLocal.set(1);

        executor.submit(() -> {
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.remove();
        });

        TimeUnit.SECONDS.sleep(1);

        threadLocal.set(2);

        executor.submit(() -> {
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.set(3);
            System.out.println("子线程读取本地变量：" + threadLocal.get());
            threadLocal.remove();
        });
        // ————————————————
        // 版权声明：本文为CSDN博主「快乐崇拜234」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        // 原文链接：https://blog.csdn.net/liubenlong007/article/details/107049975

        // 主线程开启
        // 子线程读取本地变量：1
        // 子线程读取本地变量：null
        // 子线程读取本地变量：3

    }
}
