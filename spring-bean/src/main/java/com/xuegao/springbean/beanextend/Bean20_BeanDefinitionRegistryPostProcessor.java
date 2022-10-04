package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class Bean20_BeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        // 调用时间点
        // org.springframework.context.support.AbstractApplicationContext#invokeBeanFactoryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
        // PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors postProcessBeanDefinitionRegistry
        OnlyPrintUtil.print(getClass(), "postProcessBeanDefinitionRegistry");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // 调用时间点
        // org.springframework.context.support.AbstractApplicationContext#invokeBeanFactoryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(java.util.Collection<? extends org.springframework.beans.factory.config.BeanFactoryPostProcessor>, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(java.util.Collection<? extends org.springframework.beans.factory.config.BeanFactoryPostProcessor>, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
        OnlyPrintUtil.print(getClass(), "postProcessBeanFactory");
    }
}
