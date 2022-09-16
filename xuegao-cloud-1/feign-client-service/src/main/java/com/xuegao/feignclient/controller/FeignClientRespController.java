package com.xuegao.feignclient.controller;

import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import com.xuegao.config.concurrent.ThreadPoolConfig;
import com.xuegao.feignclient.call.feignserver.FeignRespCall;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;

@RestController
public class FeignClientRespController {
    private static final Logger log = LoggerFactory.getLogger(FeignClientRespController.class);

    @Autowired
    private FeignRespCall feignRespCall;

    @Autowired
    @Qualifier(ThreadPoolConfig.XUEGAO_THREAD_NAME_BEAN)
    // @Qualifier("xuegaoSpringTaskExecutor")
    private Executor asyncTaskExecutor;

    @RequestMapping(path = "/feignResp/test1", method = RequestMethod.GET)
    public String test1() {
        return feignRespCall.feignRespTest1();
    }

    @RequestMapping(path = "/feignResp/test2", method = RequestMethod.GET)
    public String test2() {
        log.info("[xue-gao-write-and-use][FeignClientRespController][test2][1111111111111]");
        asyncTaskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                log.info("[xue-gao-write-and-use][FeignClientRespController][run][22222222]");
                log.info("[xue-gao-write-and-use][FeignClientRespController][run][222222222222]");
            }
        });

        return "/feignResp/test2";
    }
}
