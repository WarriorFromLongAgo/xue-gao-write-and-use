package com.xuegao.testdynamictp;

import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootTest
public class CommonExecutor1Test {

    @Resource
    private ThreadPoolExecutor commonExecutor;

    @Autowired
    @Qualifier("commonExecutor")
    private ThreadPoolExecutor commonExecutor1;

    @Test
    public void contextLoads() {
        commonExecutor.execute(() -> System.out.println("test"));

        commonExecutor1.execute(() -> System.out.println("test"));

        DtpExecutor commonExecutor11 = DtpRegistry.getDtpExecutor("commonExecutor");
        System.out.println();
    }
}
