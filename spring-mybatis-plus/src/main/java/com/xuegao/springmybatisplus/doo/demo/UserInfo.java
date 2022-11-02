package com.xuegao.springmybatisplus.doo.demo;

import com.xuegao.mapper.model.GenericModel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
public class UserInfo extends GenericModel<Integer> {

    private String username;

    private String password;

    public UserInfo() {
    }
}