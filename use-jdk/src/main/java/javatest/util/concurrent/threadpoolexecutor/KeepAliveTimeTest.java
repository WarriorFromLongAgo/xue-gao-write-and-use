package javatest.util.concurrent.threadpoolexecutor;

public class KeepAliveTimeTest {
    // private static final AtomicInteger COUNT = new AtomicInteger();
    //
    // private static final ThreadPoolExecutor MANY_POOL_EXECUTOR = new ThreadPoolExecutor(
    //         1,
    //         2,
    //         1L,
    //         java.util.concurrent.TimeUnit.SECONDS,
    //         new java.util.concurrent.LinkedBlockingQueue<>(),
    //         r -> new Thread(r, "ThreadPoolBusiness" + COUNT.incrementAndGet()));
    //
    // public static void main(String[] args) {
    //     MANY_POOL_EXECUTOR.execute(new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println(" = ========== begin " + Thread.currentThread().getName());
    //             System.out.println(" = ========== end " + Thread.currentThread().getName());
    //         }
    //     });
    //     MANY_POOL_EXECUTOR.execute(new Runnable() {
    //         @Override
    //         public void run() {
    //             System.out.println(" = ========== begin " + Thread.currentThread().getName());
    //             try {
    //                 TimeUnit.SECONDS.sleep(20000);
    //             } catch (InterruptedException e) {
    //                 e.printStackTrace();
    //             }
    //             System.out.println(" = ========== end " + Thread.currentThread().getName());
    //         }
    //     });
    //
    //     TimeUnit.SECONDS.sleep(2);
    // }
}
