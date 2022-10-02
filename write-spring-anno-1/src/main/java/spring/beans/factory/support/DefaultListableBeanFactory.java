package spring.beans.factory.support;

import spring.beans.factory.config.BeanDefinition;
import spring.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    /**
     * Map of bean definition objects, keyed by bean name.
     */
    public final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>(256);
    /**
     * List of bean definition names, in registration order.
     */
    private volatile List<String> beanDefinitionNames = new ArrayList<>(256);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        this.beanDefinitionMap.put(beanName, beanDefinition);
        this.beanDefinitionNames.add(beanName);
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

    @Override
    public void preInstantiateSingletons() {
        // 获取所有已注册的 beanDefinition name。
        // Iterate over a copy to allow for init methods which in turn register new bean definitions.
        // While this may not be part of the regular factory bootstrap, it does otherwise work fine.
        List<String> beanNames = new ArrayList<>(this.beanDefinitionNames);

        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (!Objects.isNull(beanDefinition)) {
                throw new RuntimeException("IOC容器中不包含此BeanName " + beanName);
            }
            if (beanDefinition.isSingleton()) {
                getBean(beanName);
            }
        }

        // 走完这里，代表所有的bean都处理完成了
    }

}
