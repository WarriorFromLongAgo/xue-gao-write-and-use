package com.xuegao.mybatis.mapping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyEnvironment {

    private String driver;

    private String url;

    private String username;

    private String password;

}
