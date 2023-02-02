// package com.xuegao.testdynamictp;
//
// import org.junit.jupiter.api.Test;
// import org.springframework.boot.test.context.SpringBootTest;
//
// import javax.annotation.Resource;
// import java.util.concurrent.ThreadPoolExecutor;
//
// @SpringBootTest
// public class IoIntensiveExecutorTest {
//
//     @Resource
//     private ThreadPoolExecutor ioIntensiveExecutor;
//
//     @Test
//     public void contextLoads() {
//         ioIntensiveExecutor.execute(() -> System.out.println("test"));
//     }
// }
