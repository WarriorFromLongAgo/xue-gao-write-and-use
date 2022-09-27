package context.support;

import beans.factory.config.ConfigurableListableBeanFactory;
import beans.factory.support.DefaultListableBeanFactory;

public class GenericApplicationContext extends AbstractApplicationContext {

    private final DefaultListableBeanFactory beanFactory;

    public GenericApplicationContext() {
        // 父类的默认构造方法，此方法实例化一个重要的类：DefaultListableBeanFactory
        this.beanFactory = new DefaultListableBeanFactory();
    }

    @Override
    public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
        return this.beanFactory;
    }

    @Override
    public Object getBean(String name) {
        return getBeanFactory().getBean(name);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public Object getBean(String name, Object... args) {
        return getBeanFactory().getBean(name, args);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType, Object... args) {
        return getBeanFactory().getBean(requiredType, args);
    }


}
