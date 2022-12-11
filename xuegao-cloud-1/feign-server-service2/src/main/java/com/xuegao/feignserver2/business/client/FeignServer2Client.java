package com.xuegao.feignserver2.business.client;

import com.xuegao.core.model.Result;
import com.xuegao.feignserver2.business.remote.FeignServer2Remote;
import com.xuegao.model.dto.TestRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

@FeignClient(name = "feign-server-service2", contextId = "FeignServer2Client", fallback = FeignServer2Client.fallBack.class)
public interface FeignServer2Client extends FeignServer2Remote {
     Logger log = LoggerFactory.getLogger(FeignServer2Client.class);

    @Component
    class fallBack implements FeignServer2Client {
        @Override
        public Result<String> test1(TestRequest request) {
            log.info("[xue-gao-write-and-use][FeignServer2Client][fallBack][test1][]");
            return null;
        }
    }
}
