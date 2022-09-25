package beans.factory.support;

import beans.factory.BeanFactory;
import beans.factory.config.BeanDefinition;
import com.sun.istack.internal.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListableBeanFactory implements BeanFactory {
    /**
     * Map of bean definition objects, keyed by bean name.
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);


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

    protected <T> T doGetBean(String name, @Nullable Class<T> requiredType, @Nullable Object[] args) {

    }
}