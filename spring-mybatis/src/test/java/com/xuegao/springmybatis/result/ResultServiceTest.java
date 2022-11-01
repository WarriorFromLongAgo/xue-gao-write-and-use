package com.xuegao.springmybatis.result;

import com.xuegao.springmybatis.business.result.service.ResultService;
import com.xuegao.springmybatis.model.demo.doo.MybatisResult;
import com.xuegao.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultServiceTest {
    private static final Logger log = LoggerFactory.getLogger(ResultServiceTest.class);

    @Autowired
    private ResultService resultService;

    @Test
    public void test() {
        List<MybatisResult> list = resultService.list();
        log.info("[xue-gao-write-and-use][ResultServiceTest][test][list={}]", JsonUtil.toJsonString(list));

        List<Map<String, Object>> listMap = resultService.listMap();
        log.info("[xue-gao-write-and-use][ResultServiceTest][test][listMap={}]", JsonUtil.toJsonString(listMap));
    }

}
