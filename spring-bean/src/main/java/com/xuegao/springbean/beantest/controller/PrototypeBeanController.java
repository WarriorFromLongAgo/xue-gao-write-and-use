package com.xuegao.springbean.beantest.controller;

import com.xuegao.springbean.beantest.service.PrototypeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuegao
 * @version 1.0
 * @date 2023年01月30日 17:11
 */
@RestController
public class PrototypeBeanController {
    private static final Logger log = LoggerFactory.getLogger(PrototypeBeanController.class);

    @Autowired
    private PrototypeBean prototypeBean;

    @GetMapping("/test2")
    public void test(@RequestParam(name = "name") String name) {
        log.info("[xue-gao-write-and-use][PrototypeBeanController][test][prototypeBean={}]", prototypeBean);

        prototypeBean.test(name);
    }


}
