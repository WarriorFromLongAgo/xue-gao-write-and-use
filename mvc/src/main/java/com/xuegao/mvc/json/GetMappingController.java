package com.xuegao.mvc.json;

import com.xuegao.mvc.model.TestResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月29日 18:04
 */
@RestController
public class GetMappingController {
    private static final Logger log = LoggerFactory.getLogger(GetMappingController.class);

    @GetMapping(path = "/requestParam/{id}")
    public TestResp requestParam(@RequestParam("id") String id) {
        log.info("[xue-gao-write-and-use][GetMappingController][requestParam][id={}]", id);
        return TestResp.getTestResp();
    }

    @GetMapping(path = "/pathVariable/{id}")
    public TestResp pathVariable(@PathVariable("id") String id) {
        log.info("[xue-gao-write-and-use][GetMappingController][pathVariable][id={}]", id);
        return TestResp.getTestResp();
    }
}
