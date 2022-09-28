package spring.beans.factory.support;

import spring.beans.factory.config.BeanDefinition;
import spring.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListableBeanFactory extends AbstractBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    /**
     * Map of bean definition objects, keyed by bean name.
     */
    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition bd = this.beanDefinitionMap.get(beanName);
        if (bd == null) {
            throw new RuntimeException(beanName + "不存在");
        }
        return bd;
    }

    @Override
    public void removeBeanDefinition(String beanName) {
        BeanDefinition bd = this.beanDefinitionMap.remove(beanName);
        if (bd == null) {
            throw new RuntimeException(beanName + "不存在");
        }
    }
}
