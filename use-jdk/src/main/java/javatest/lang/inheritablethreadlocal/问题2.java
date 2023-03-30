package javatest.lang.inheritablethreadlocal;

public class 问题2 {
    // public static void main(String[] args) throws InterruptedException {
    //     // 当InheritableThreadLocal遇到线程池：主线程本地变量修改后，子线程无法读取到新值
    //     // 注意: 建议使用长度为1的线程池测试,确保是同一个Thread
    //     ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();
    //     ThreadPoolExecutor executor = MyThreadPool.getOneOneArrayPoolExecutor();
    //
    //     System.out.println("主线程开启");
    //     threadLocal.set(new Stu("aaa",1));
    //
    //     executorService.submit(() -> {
    //         System.out.println("子线程读取本地变量：" + threadLocal.get());
    //         threadLocal.get().setAge(55);
    //         System.out.println("子线程读取本地变量：" + threadLocal.get());
    //
    //     });
    //
    //     TimeUnit.SECONDS.sleep(1);
    //
    //     System.out.println("主线程读取本地变量：" + threadLocal.get());
    //     threadLocal.get().setAge(99);
    //
    //     executorService.submit(() -> {
    //         System.out.println("子线程读取本地变量：" + threadLocal.get());
    //     });
    //     // ————————————————
    //     // 版权声明：本文为CSDN博主「快乐崇拜234」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //     // 原文链接：https://blog.csdn.net/liubenlong007/article/details/107049975
    // }

    // 主线程开启
    // 子线程读取本地变量：Stu(name=aaa, age=1)
    // 子线程读取本地变量：Stu(name=aaa, age=55)
    // 主线程读取本地变量：Stu(name=aaa, age=55)
    // 子线程读取本地变量：Stu(name=aaa, age=99)

    // 务必关心传递对象的线程安全问题！！

    // 实现线程本地变量的拷贝
    // 很简单，只需要重写java.lang.InheritableThreadLocal#childValue方法即可.
    // 这里自定义一个MyInheritableThreadLocal类，实现对象的拷贝。
    // 我这里使用的序列化反序列化的方式，当然也可以用其他方式。

    // public class MyInheritableThreadLocal<T> extends InheritableThreadLocal<T> {
    //     protected T childValue(T parentValue) {
    //         String s = JSONObject.toJSONString(parentValue);
    //         return (T)JSONObject.parseObject(s,parentValue.getClass());
    //     }
    // }



}
