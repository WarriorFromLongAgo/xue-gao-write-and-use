// package com.xuegao.springsecuritydemo1.config;
//
// import org.springframework.boot.autoconfigure.security.SecurityProperties;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
// @Configuration
// @Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
// public class ApplicationConfigurerAdapter extends WebSecurityConfigurerAdapter {
//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         // http.antMatcher("/test01/**")
//         //         .authorizeRequests()
//         //         .antMatchers("/test01/noRole").hasRole("USER")
//         //         .antMatchers("/match1/hasRole").hasRole("SPAM")
//         //         .anyRequest()
//         //         .authenticated();
//
//         http.antMatcher("/test01/**")
//                 .authorizeRequests()
//                 .antMatchers("/test01/noRole").hasRole("USER")
//                 .antMatchers("/match1/hasRole").hasRole("SPAM")
//                 .anyRequest()
//                 .authenticated();
//
//         // http
//         // .antMatcher("/test01/**")
//         // .antMatcher("/test02/**");
//     }
// }