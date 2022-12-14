package com.xuegao.testdynamictp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
public class DtpExecutor1Test {

    @Resource
    private ThreadPoolExecutor dtpExecutor1;

    @Test
    public void contextLoads() {
        dtpExecutor1.execute(() -> System.out.println("test"));
    }
}
