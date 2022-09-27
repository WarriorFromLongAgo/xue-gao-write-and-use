package context.support;

import beans.factory.config.ConfigurableBeanFactory;

public abstract class AbstractBeanFactory implements ConfigurableBeanFactory {

    @Override
    public Object getBean(String name) {
        return this.doGetBean(name, null, null);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return this.doGetBean(name, requiredType, null);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return this.doGetBean(name, null, args);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return this.doGetBean(null, requiredType, null);
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) {
        return this.doGetBean(null, requiredType, args);
    }

    protected <T> T doGetBean(String name, Class<T> requiredType, Object[] args) {
        Object bean = null;


        return (T) bean;
    }


    // protected abstract Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)
    //         throws BeanCreationException;
}
