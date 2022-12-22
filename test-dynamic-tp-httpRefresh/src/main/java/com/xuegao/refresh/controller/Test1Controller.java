package com.xuegao.refresh.controller;

import com.dtp.common.ApplicationContextHolder;
import com.dtp.common.properties.DtpProperties;
import com.dtp.common.properties.ThreadPoolProperties;
import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class Test1Controller {

    // No qualifying bean of type 'java.util.concurrent.ThreadPoolExecutor'
    // @Autowired
    // @Qualifier(value = "dtpExecutor1")
    // private ThreadPoolExecutor dtpExecutor1ThreadPoolExecutor;

    // No qualifying bean of type 'java.util.concurrent.ThreadPoolExecutor'
    // @Autowired
    // @Qualifier(value = "thread_num_2")
    // private ThreadPoolExecutor thread_num_2ThreadPoolExecutor;

    @Resource
    private ThreadPoolExecutor dtpExecutor1;

    @Resource
    private ThreadPoolExecutor dtpExecutor2;

    @Resource
    private ThreadPoolExecutor dtpExecutor3;

    @Resource
    private ThreadPoolExecutor thread_num_2;

    @Autowired
    private DtpProperties dtpProperties;

    @RequestMapping("/test1")
    public void test() {
        System.out.println("test1");

        dtpExecutor1.execute(() -> System.out.println("dtpExecutor1"));
        dtpExecutor2.execute(() -> System.out.println("dtpExecutor2"));
        dtpExecutor3.execute(() -> System.out.println("dtpExecutor3"));
        thread_num_2.execute(() -> System.out.println("thread_num_2"));

        // dtpExecutor1ThreadPoolExecutor.execute(() -> System.out.println("dtpExecutor1ThreadPoolExecutor"));

        // thread_num_2ThreadPoolExecutor.execute(() -> System.out.println("thread_num_2ThreadPoolExecutor"));

        List<ThreadPoolProperties> executors = dtpProperties.getExecutors();
        DtpExecutor bean = ApplicationContextHolder.getBean(DtpExecutor.class);

        List<String> strings = DtpRegistry.listAllDtpNames();

        // DtpExecutor dtpExecutor1 = DtpRegistry.getDtpExecutor("dtpExecutor1");

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
