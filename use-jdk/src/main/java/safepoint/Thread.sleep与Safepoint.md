public class MainTest {

public static AtomicInteger num = new AtomicInteger(0);

public static void main(String[] args) throws InterruptedException {
Runnable runnable=()->{
for (int i = 0; i < 1000000000; i++) {
num.getAndAdd(1);
}
System.out.println(Thread.currentThread().getName()+"执行结束!");
};

Thread t1 = new Thread(runnable);
Thread t2 = new Thread(runnable);
t1.start();
t2.start();
Thread.sleep(1000);
System.out.println("num = " + num);
}
}

作者：why技术
链接：https://juejin.cn/post/7139741080597037063
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。