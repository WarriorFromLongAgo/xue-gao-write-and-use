package spring.beans.factory.support;

import spring.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {


    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    BeanDefinition getBeanDefinition(String beanName);

    void removeBeanDefinition(String beanName);

}