package com.xuegao.feignserver.business.remote;

import com.xuegao.model.dto.TestRequest;
import com.xuegao.model.vo.TestResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface FeignEurekaRemoteController {

    @RequestMapping(path = "/feignEureka/test1", method = RequestMethod.POST)
    TestResponse test1(@RequestBody TestRequest request);
}
