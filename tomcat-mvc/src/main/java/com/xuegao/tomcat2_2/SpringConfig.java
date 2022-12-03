package com.xuegao.tomcat2_2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring不扫描controller组件、
 * AOP咋实现的，事务 看Spring容器
 */
@Configuration
@ComponentScan(value = "com.xuegao.tomcat2_2", excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
})
public class SpringConfig {
    // Spring父容器
}