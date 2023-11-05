package com.xuegao.springsecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test02Controller {

    @GetMapping("/test02/noRole")
    public String test01() {

        return "test02";
    }

    @GetMapping("/test02/hasRole")
    public String test01_has() {

        return "test02_has";
    }
}
