package com.xuegao.springbean.beanextend;

import org.springframework.beans.factory.BeanNameAware;

public class Bean8_BeanNameAware implements BeanNameAware {
    public Bean8_BeanNameAware() {
        System.out.println("[bean extend] Bean8_BeanNameAware constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("[bean extend] Bean8_BeanNameAware setBeanName");
    }
}
