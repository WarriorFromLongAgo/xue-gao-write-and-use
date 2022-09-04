package com.xuegao.testdemo1.controller;

import com.xuegao.xuegaoautoconfigspringbootstarter.service.HelloService1;
import com.xuegao.xuegaoautoconfigspringbootstarter.service.HelloService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StarController {
    //采用注解的方式使用star-test-2的类
    @Autowired
    HelloService1 helloService1;
    @Autowired
    HelloService2 helloService2;

    @GetMapping("/hello")
    public void hello() {
        System.out.println(helloService1.hello("张三"));
        System.out.println(helloService2.hello());
    }
}