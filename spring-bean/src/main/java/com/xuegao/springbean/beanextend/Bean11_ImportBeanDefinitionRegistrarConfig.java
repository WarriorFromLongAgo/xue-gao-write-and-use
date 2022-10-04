package com.xuegao.springbean.beanextend;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Import(Bean10_ImportBeanDefinitionRegistrar.class)
public class Bean11_ImportBeanDefinitionRegistrarConfig implements ImportBeanDefinitionRegistrar {

    public static class Bean11_ImportBeanDefinitionRegistrarTestService {
        public void test1() {
            System.out.println("Bean11_ImportBeanDefinitionRegistrarTestService test1");
        }
    }
}
