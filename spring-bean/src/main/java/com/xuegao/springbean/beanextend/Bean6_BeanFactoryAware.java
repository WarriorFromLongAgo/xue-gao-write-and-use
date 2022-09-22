package com.xuegao.springbean.beanextend;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Bean6_BeanFactoryAware implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("[bean extend][Bean6_BeanFactoryAware] " + beanFactory.getBean(Bean6_BeanFactoryAware.class).getClass().getSimpleName());
    }
}
