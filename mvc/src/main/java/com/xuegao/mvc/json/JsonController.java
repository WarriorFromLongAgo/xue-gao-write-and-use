package com.xuegao.mvc.json;

import com.xuegao.mvc.model.TestResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月29日 18:04
 */
@RestController
public class JsonController {
    private static final Logger log = LoggerFactory.getLogger(JsonController.class);

    @RequestMapping(path = "/json/get", method = {RequestMethod.GET})
    public TestResp getJson() {
        log.info("[xue-gao-write-and-use][JsonController][getJson][]");
        return TestResp.getTestResp();
    }

    @RequestMapping(path = "/json/post", method = {RequestMethod.POST})
    public TestResp postJson() {
        return TestResp.getTestResp();
    }

    @RequestMapping(path = "/json/post/v2", method = {RequestMethod.POST})
    public TestResp postJsonV2(@RequestBody TestResp testResp) {
        log.info("[xue-gao-write-and-use][JsonController][postJsonV2][]");
        return TestResp.getTestResp();
    }
}
