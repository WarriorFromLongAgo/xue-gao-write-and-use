package com.xuegao.springbean.beanextend;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;

import java.lang.reflect.Constructor;

public class Bean5_SmartInstantiationAwareBeanPostProcessor implements SmartInstantiationAwareBeanPostProcessor {

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] predictBeanType " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] determineCandidateConstructors " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] getEarlyBeanReference " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.getEarlyBeanReference(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] postProcessBeforeInstantiation " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] postProcessAfterInstantiation " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] postProcessProperties " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] postProcessBeforeInitialization " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[bean extend][Bean5_SmartInstantiationAwareBeanPostProcessor] postProcessAfterInitialization " + beanName);
        return SmartInstantiationAwareBeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
