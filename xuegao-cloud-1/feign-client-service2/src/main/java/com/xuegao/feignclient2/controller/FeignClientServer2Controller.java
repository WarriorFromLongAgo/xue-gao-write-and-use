package com.xuegao.feignclient2.controller;

import com.xuegao.feignclient2.call.FeignServer2Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientServer2Controller {

    @Autowired
    private FeignServer2Call feignServer2Call;

    @RequestMapping("/feignClientServer2/test1")
    public void test1() {
        feignServer2Call.test1();
    }

}
