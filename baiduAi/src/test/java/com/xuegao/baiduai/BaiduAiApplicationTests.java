package com.xuegao.baiduai;

import com.xuegao.baiduai.http.Sample;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class BaiduAiApplicationTests {

    @Autowired
    private Sample sample;


    @Test
    void contextLoads() throws IOException, InterruptedException {

        String taskId = sample.asdadadaa();

        TimeUnit.SECONDS.sleep(10);

        sample.after(taskId);
    }

    @Test
    void after() throws IOException, InterruptedException {

        TimeUnit.SECONDS.sleep(5);
        sample.after("6374b9aa9a8e930001dc53a7");
    }
}
