package com.xuegao.springbean.beanextend;

import org.springframework.beans.factory.FactoryBean;

public class Bean10_FactoryBean implements FactoryBean<Bean10_FactoryBean.TestFactoryInnerBean> {

    @Override
    public Bean10_FactoryBean.TestFactoryInnerBean getObject() throws Exception {
        System.out.println("[bean extend][Bean10_FactoryBean] getObject");
        return new Bean10_FactoryBean.TestFactoryInnerBean();
    }

    @Override
    public Class<?> getObjectType() {
        return Bean10_FactoryBean.TestFactoryInnerBean.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public static class TestFactoryInnerBean {

    }
}
