package com.xuegao.bootarthas.controller;

import com.xuegao.bootarthas.service.TestService;
import com.xuegao.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/test1")
    public String test1() {
        TestService.staticTest1("TestController");
        String test1 = SpringUtil.getBean(TestService.class).test1("222");
        System.out.println(test1);
        return testService.test1(" TestController");
    }

}
