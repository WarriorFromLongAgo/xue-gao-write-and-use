package com.xuegao.xuegaoautoconfigspringbootstarter.service;

import java.util.Date;

public class HelloService2 {
    public Long hello() {
        return new Date().getTime();
    }
}