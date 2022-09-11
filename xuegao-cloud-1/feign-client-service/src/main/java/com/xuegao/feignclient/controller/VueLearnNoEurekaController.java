package com.xuegao.feignclient.controller;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.JsonUtil;
import com.xuegao.feignclient.call.feignserver.VueLearnNoEurekaCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VueLearnNoEurekaController {
    private static final Logger log = LoggerFactory.getLogger(VueLearnNoEurekaController.class);

    @Autowired
    private VueLearnNoEurekaCall vueLearnNoEurekaCall;

    @RequestMapping(path = "/im/login", method = RequestMethod.GET)
    public JSONObject get1() {
        log.info("[xue-gao-write-and-use][VueLearnNoEurekaController][get1][]");
        JSONObject response = vueLearnNoEurekaCall.get1();
        log.info("[xue-gao-write-and-use][VueLearnNoEurekaController][get1][={}]", JsonUtil.toJsonString(response));
        return response;
    }
}
