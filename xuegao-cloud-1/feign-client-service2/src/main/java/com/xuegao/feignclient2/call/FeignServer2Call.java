package com.xuegao.feignclient2.call;

import com.xuegao.JsonUtil;
import com.xuegao.RespUtil;
import com.xuegao.feignserver2.business.client.FeignServer2Client;
import com.xuegao.feignserver2.business.client.FeignServer2ClientV2;
import com.xuegao.model.dto.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeignServer2Call {
    private static final Logger log = LoggerFactory.getLogger(FeignServer2Call.class);

    @Autowired
    private FeignServer2Client feignServer2Client;
    @Autowired
    private FeignServer2ClientV2 feignServer2ClientV2;

    public void test1() {
        TestRequest testRequest = new TestRequest();
        RespUtil<String> stringRespUtil = feignServer2Client.test1(testRequest);
        log.info("[xue-gao-write-and-use][FeignServer2Call][test1][={}]", JsonUtil.toJsonString(stringRespUtil));
        RespUtil<String> stringRespUtilV2 = feignServer2ClientV2.test1(testRequest);
        log.info("[xue-gao-write-and-use][FeignServer2Call][test1][={}]", JsonUtil.toJsonString(stringRespUtilV2));
    }
}
