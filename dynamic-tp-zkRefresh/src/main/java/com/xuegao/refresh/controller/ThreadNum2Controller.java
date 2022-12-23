package com.xuegao.refresh.controller;

import com.dtp.common.properties.DtpProperties;
import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class ThreadNum2Controller {

    @Autowired
    @Qualifier(value = "thread_num_2")
    private ThreadPoolExecutor thread_num_2ThreadPoolExecutor;

    @Autowired
    private DtpProperties dtpProperties;

    @RequestMapping("/thread_num_2/test1")
    public void test() {
        System.out.println("test1");

        thread_num_2ThreadPoolExecutor.execute(() -> System.out.println("thread_num_2"));

        DtpExecutor thread_num_2 = DtpRegistry.getDtpExecutor("thread_num_2");
        System.out.println("thread_num_2 = " + thread_num_2);
        thread_num_2.execute(() -> {
            System.out.println("test111111");
        });

        System.out.println("test2");
    }

    // DtpExecutor dtpExecutor = DtpRegistry.getDtpExecutor("dtpExecutor1");
   // dtpExecutor.execute(() -> System.out.println("test"));
}
