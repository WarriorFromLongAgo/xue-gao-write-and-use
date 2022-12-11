package com.xuegao.feignserver2.business.client;

import com.xuegao.core.model.Result;
import com.xuegao.feignserver2.business.remote.FeignServer2RemoteV2;
import com.xuegao.model.dto.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "feign-server-service2", contextId = "FeignServer2ClientV2", fallback = FeignServer2ClientV2.fallBack.class)
public interface FeignServer2ClientV2 extends FeignServer2RemoteV2 {
    Logger log = LoggerFactory.getLogger(FeignServer2ClientV2.class);

    @Component
    class fallBack implements FeignServer2ClientV2 {
        @Override
        public Result<String> test1(TestRequest request) {
            log.info("[xue-gao-write-and-use][FeignServer2ClientV2][fallBack][test1][]");
            return null;
        }
    }
}
