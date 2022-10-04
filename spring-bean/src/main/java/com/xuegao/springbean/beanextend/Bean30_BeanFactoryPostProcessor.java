package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class Bean30_BeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        OnlyPrintUtil.print(getClass(), "postProcessBeanFactory");
        // 调用时间点
        // Bean30_BeanFactoryPostProcessor 对象先创建
        // 在创建这个对象的时候，org.springframework.context.event.internalEventListenerFactory
        // 调用此方法

        // AbstractApplicationContext.invokeBeanFactoryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(java.util.Collection<? extends org.springframework.beans.factory.config.BeanFactoryPostProcessor>, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(java.util.Collection<? extends org.springframework.beans.factory.config.BeanFactoryPostProcessor>, org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
        // EventListenerMethodProcessor.postProcessBeanFactory
        // DefaultListableBeanFactory.getBeansOfType(java.lang.Class<T>, boolean, boolean)


    }
}
