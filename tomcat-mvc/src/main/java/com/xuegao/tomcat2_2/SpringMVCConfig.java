package com.xuegao.tomcat2_2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * SpringMVC只扫描controller组件，可以不指定父容器类，让MVC扫所有。@Component+@RequestMapping就生效了
 */
@ComponentScan(value = "com.xuegao.tomcat2_2", includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)
}, useDefaultFilters = false)
@Configuration
public class SpringMVCConfig {

    // SpringMVC 子容器，能扫描的Spring容器中的组件
}

