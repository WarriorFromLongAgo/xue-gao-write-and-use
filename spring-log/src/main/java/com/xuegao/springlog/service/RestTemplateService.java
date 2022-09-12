package com.xuegao.springlog.service;

import com.xuegao.util.RestTemplateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RestTemplateService {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateService.class);

    public void getCrmTestGet() {
        String s = RestTemplateUtil.sendGet("http://127.0.0.1:8081/test/get", String.class);
        log.info("[spring-log][RestTemplateService][getTestGet][s={}]", s);
    }
}