package com.xuegao.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<TestFirstFilter> testFirstFilter() {
        FilterRegistrationBean<TestFirstFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new TestFirstFilter());
        registration.addUrlPatterns("/*");
        // registration.setName("testFirstFilter");
        // registration.setOrder(-1);
        return registration;
    }
}
