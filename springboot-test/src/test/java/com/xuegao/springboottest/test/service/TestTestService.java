package com.xuegao.springboottest.test.service;

import com.xuegao.springboottest.model.SysUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestTestService {

    @Autowired
    private TestService testService;

    @Test
    public void testTest() {
        SysUser aaaaaa = testService.test("aaaaaa");
        System.out.println(" == " + aaaaaa);
    }

}
