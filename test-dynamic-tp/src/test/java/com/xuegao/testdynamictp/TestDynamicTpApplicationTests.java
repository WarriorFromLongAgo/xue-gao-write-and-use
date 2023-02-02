package com.xuegao.testdynamictp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.AsyncTaskExecutor;

@SpringBootTest
public class TestDynamicTpApplicationTests {

    @Qualifier("myAsyncTaskExecutor")
    @Autowired
    private AsyncTaskExecutor myAsyncTaskExecutor;

    @Test
    public void contextLoads() {
        myAsyncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("dasdadaada");
            }
        });
    }

}
