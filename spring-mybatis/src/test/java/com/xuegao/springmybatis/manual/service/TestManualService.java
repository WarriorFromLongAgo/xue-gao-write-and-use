package com.xuegao.springmybatis.manual.service;


import com.xuegao.springmybatis.business.manual.ManualService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestManualService {

    @Autowired
    private ManualService manualService;

    @Test
    public void insert() {
        manualService.insert1();
    }


}
