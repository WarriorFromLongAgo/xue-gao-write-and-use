package com.xuegao.mpluspgsql.mvc;

import com.xuegao.log.web.filter.FmkLogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<FmkLogFilter> testFmkLogFilter() {
        FilterRegistrationBean<FmkLogFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new FmkLogFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

}