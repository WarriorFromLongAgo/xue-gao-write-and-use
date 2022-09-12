package com.xuegao.feignserverlogservice.service;

import com.xuegao.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateService {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateService.class);

    public void getHrTestGet() {
        String s = RestTemplateUtil.sendGet("http://127.0.0.1:8080/test/get1", String.class);
        log.info("[xue-gao-write-and-use][RestTemplateService][getHrTestGet1][s={}]", s);
    }
}