package com.xuegao.springcloudstarteroauth2demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// spring security 基础配置

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 这个类的重点就是声明 PasswordEncoder 和 AuthenticationManager两个 Bean。稍后会用到。
    // 其中 BCryptPasswordEncoder是一个密码加密工具类，它可以实现不可逆的加密，
    // AuthenticationManager是为了实现 OAuth2 的 password 模式必须要指定的授权管理 Bean。

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 允许匿名访问所有接口 主要是 oauth 接口
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // .formLogin().permitAll()
                // .requestMatchers()
                // .antMatchers("/oauth/token")

                // .and()
                //
                .authorizeRequests()
                .antMatchers("/**")
                .permitAll()

                // .anyRequest().authenticated()

                .and().csrf().disable();
    }
}