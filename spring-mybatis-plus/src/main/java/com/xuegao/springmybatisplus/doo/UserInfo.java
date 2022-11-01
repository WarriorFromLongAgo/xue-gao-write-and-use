package com.xuegao.springmybatisplus.doo;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

    private Integer id;

    private String username;

    private String password;

    public UserInfo() {
    }
}