package com.xuegao.feignclient.controller;

import com.xuegao.feignclient.call.feignserver.FeignRespCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignClientRespController {
    private static final Logger log = LoggerFactory.getLogger(FeignClientRespController.class);

    @Autowired
    private FeignRespCall feignRespCall;

    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.GET)
    public String test1() {
        return feignRespCall.feignRespTest1();
    }
}
