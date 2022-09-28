package spring.context.support;

import spring.beans.factory.config.BeanDefinition;
import spring.beans.factory.config.ConfigurableListableBeanFactory;
import spring.beans.factory.support.BeanDefinitionRegistry;
import spring.beans.factory.support.DefaultListableBeanFactory;

public class GenericApplicationContext extends AbstractApplicationContext implements BeanDefinitionRegistry {
    private final DefaultListableBeanFactory beanFactory;

    public GenericApplicationContext() {
        // 父类的默认构造方法，此方法实例化一个重要的类：DefaultListableBeanFactory
        this.beanFactory = new DefaultListableBeanFactory();
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanFactory.registerBeanDefinition(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        return this.beanFactory.getBeanDefinition(beanName);
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        this.beanFactory.removeBeanDefinition(beanName);
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() {
        return this.beanFactory;
    }
}
