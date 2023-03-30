package javatest.lang.inheritablethreadlocal;

import common.thread.MyThreadPool;

import java.util.concurrent.ThreadPoolExecutor;

public class 线程池中traceid传递2 {

    // 最外层是线程池1,设置了之后,
    // 第一次可以传递到线程池2里面，
    // 因为第一次get的时候,getMap方法,会把ThreadLocal.ThreadLocalMap获取到

    // 但是第二次,就不可以传递到线程池2里面
    // 因为 InheritableThreadLocal 里面的 ThreadLocalMap 里面的 Entry 里面的 value 是弱引用,所以第二次就被回收了
    // 在 set 的时候,会触发
    // cleanSomeSlots 主要作用：循环的去寻找脏Entry，即key=null的Entry，然后进行删除。

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyArrayPoolExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
                    threadLocal.set("hello");

                    ThreadPoolExecutor threadPoolExecutor = MyThreadPool.getManyManyListPoolExecutor();
                    for (int j = 0; j < 2; j++) {
                        threadPoolExecutor.execute(new Runnable() {
                            @Override
                            public void run() {
                                System.out.println(Thread.currentThread().getName() + " === " + threadLocal.get());
                            }
                        });
                    }
                }
            });
        }
    }
}
