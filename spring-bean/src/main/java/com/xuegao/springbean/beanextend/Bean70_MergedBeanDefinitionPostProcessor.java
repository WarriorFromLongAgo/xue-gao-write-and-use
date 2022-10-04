package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class Bean70_MergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        OnlyPrintUtil.print(getClass(), "postProcessMergedBeanDefinition");
    }

    @Override
    public void resetBeanDefinition(String beanName) {
        MergedBeanDefinitionPostProcessor.super.resetBeanDefinition(beanName);
        OnlyPrintUtil.print(getClass(), "resetBeanDefinition");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        OnlyPrintUtil.print(getClass(), "postProcessBeforeInitialization");
        return MergedBeanDefinitionPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        OnlyPrintUtil.print(getClass(), "postProcessAfterInitialization");
        return MergedBeanDefinitionPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
