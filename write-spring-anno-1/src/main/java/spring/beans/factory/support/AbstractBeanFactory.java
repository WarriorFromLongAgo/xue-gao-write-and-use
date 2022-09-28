package spring.beans.factory.support;

import spring.beans.factory.BeanFactory;

public abstract class AbstractBeanFactory implements BeanFactory {

    @Override
    public Object getBean(String name) {
        return this.doGetBean(name, null, null);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return this.doGetBean(name, requiredType, null);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return this.doGetBean(null, requiredType, null);
    }

    protected <T> T doGetBean(String name, Class<T> requiredType, Object[] args) {
        Object bean = null;


        return (T) bean;
    }
}
