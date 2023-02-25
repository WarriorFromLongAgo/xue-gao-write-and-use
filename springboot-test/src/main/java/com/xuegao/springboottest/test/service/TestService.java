package com.xuegao.springboottest.test.service;

import com.xuegao.springboottest.model.SysUser;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public SysUser test(String str) {
        SysUser sysUser = new SysUser();
        sysUser.setUsername(str);
        return sysUser;
    }


}
