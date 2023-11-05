package com.xuegao.springsecuritydemo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test01Controller {

    @GetMapping("/test01/noRole")
    public String test01() {

        return "test01";
    }

    @GetMapping("/test01/hasRole")
    public String test01_has() {

        return "test01_has";
    }
}
