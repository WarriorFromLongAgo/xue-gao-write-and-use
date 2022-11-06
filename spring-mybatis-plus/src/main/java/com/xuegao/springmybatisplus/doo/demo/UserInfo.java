package com.xuegao.springmybatisplus.doo.demo;

import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo extends GenericModel<Integer> {

    private String username;

    private String password;

    public UserInfo() {
    }
}