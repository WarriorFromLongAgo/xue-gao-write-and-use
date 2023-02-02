// package com.xuegao.testdynamictp;
//
// import com.dtp.common.config.DtpProperties;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import javax.annotation.Resource;
// import java.util.concurrent.ThreadPoolExecutor;
// import java.util.concurrent.TimeUnit;
//
// @SpringBootTest
// public class DtpExecutor2Test {
//
//     @Resource
//     private ThreadPoolExecutor dtpExecutor2;
//
//     @Resource
//     private ThreadPoolExecutor afterExecute;
//
//     @Autowired
//     private DtpProperties dtpProperties;
//
//     @Test
//     public void contextLoads() throws InterruptedException {
//         for (int i = 0; i < 15; i++) {
//             dtpExecutor2.execute(() -> {
//                 System.out.println(Thread.currentThread().getName() + " is running");
//                 try {
//                     TimeUnit.SECONDS.sleep(1);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             });
//         }
//
//         dtpExecutor2.shutdown();
//
//         TimeUnit.SECONDS.sleep(100);
//     }
//
//     @Test
//     public void beforeExecuteAndAfterExecute() throws InterruptedException {
//         for (int i = 0; i < 102; i++) {
//             afterExecute.execute(() -> {
//                 System.out.println(Thread.currentThread().getName() + " is running");
//             });
//         }
//
//         TimeUnit.SECONDS.sleep(100);
//     }
//
//     @Test
//     public void beforeReject() throws InterruptedException {
//         for (int i = 0; i < 102; i++) {
//             dtpExecutor2.execute(() -> {
//                 System.out.println(Thread.currentThread().getName() + " is running");
//                 try {
//                     TimeUnit.SECONDS.sleep(1000000);
//                 } catch (InterruptedException e) {
//                     e.printStackTrace();
//                 }
//             });
//         }
//
//         TimeUnit.SECONDS.sleep(100);
//     }
// }
