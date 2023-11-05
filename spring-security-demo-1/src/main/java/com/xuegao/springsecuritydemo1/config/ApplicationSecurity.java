// package com.xuegao.springsecuritydemo1.config;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
// @Configuration
// public class ApplicationSecurity extends WebSecurityConfigurerAdapter {
//
//
//   @Autowired
//   public void initialize(AuthenticationManagerBuilder builder) {
//     builder.withUser("dave")
//       .password("secret").roles("USER");
//   }
//
// }