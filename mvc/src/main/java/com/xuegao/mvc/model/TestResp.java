package com.xuegao.mvc.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022年11月29日 18:04
 */
@Getter
@Setter
public class TestResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String password;

    public static TestResp getTestResp() {
        TestResp testResp = new TestResp();
        testResp.setId(1);
        testResp.setUsername("username1");
        testResp.setPassword("password1");
        return testResp;
    }
}
