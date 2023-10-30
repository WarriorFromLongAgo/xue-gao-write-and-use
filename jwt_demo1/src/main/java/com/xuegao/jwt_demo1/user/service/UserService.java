package com.xuegao.jwt_demo1.user.service;

import com.xuegao.jwt_demo1.user.domain.UserInfo;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    public UserInfo getByUsername() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(100L);
        userInfo.setUsername("username100");
        userInfo.setPassword(UUID.randomUUID().toString());
        return userInfo;
    }

}
