package com.xuegao.eurekaserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 1
        // 忽然 /eureka/** 的所有请求
        // http.csrf().ignoringAntMatchers("/eureka/**");

        // 2
        // 注意：这里如果直接 disable 的话，会把密码验证也关闭了
        http
                .csrf()
                .disable()
        // .authorizeRequests()
        // .anyRequest()
        // .authenticated()
        // .and()
        // .httpBasic()
        ;
        // ————————————————
        // 版权声明：本文为CSDN博主「风落_」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
        // 原文链接：https://blog.csdn.net/qq_45523411/article/details/124527083
    }
}
