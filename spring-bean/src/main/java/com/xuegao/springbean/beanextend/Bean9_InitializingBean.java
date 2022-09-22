package com.xuegao.springbean.beanextend;

import org.springframework.beans.factory.InitializingBean;

public class Bean9_InitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("[bean extend][Bean9_InitializingBean] afterPropertiesSet");
    }
}
