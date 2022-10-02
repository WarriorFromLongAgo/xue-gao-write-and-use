package spring.beans.factory.support;

import com.sun.istack.internal.Nullable;
import spring.beans.factory.config.BeanDefinition;
import spring.beans.factory.config.ConfigurableBeanFactory;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements ConfigurableBeanFactory {

    /**
     * Map from bean name to merged RootBeanDefinition.
     */
    private final Map<String, RootBeanDefinition> mergedBeanDefinitions = new ConcurrentHashMap<>(256);

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

        Object singleton = getSingleton(name);
        if (Objects.nonNull(singleton)) {
            bean = singleton;
        }
        try {
            RootBeanDefinition mbd = getMergedLocalBeanDefinition(name);
            //创建单例 bean实例
            if (mbd.isSingleton()) {
                singleton = getSingleton(name, () -> {
                    // 这里返回的是一个 ObjectFactory
                    return createBean(name, mbd, args);
                });
            }
            bean = getObjectForBeanInstance(singleton, name, name, mbd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 这个bean就是数学都填充完了
        return (T) bean;
    }

    protected Object getObjectForBeanInstance(
            Object beanInstance, String name, String beanName, @Nullable RootBeanDefinition mbd) {

        return beanInstance;

        // 如果不是 FactoryBean 直接返回
        // if (!(beanInstance instanceof FactoryBean) || BeanFactoryUtils.isFactoryDereference(name)) {
        //     return beanInstance;
        // }
        //
        // return
    }

    protected abstract Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args);

    protected RootBeanDefinition getMergedLocalBeanDefinition(String beanName) {
        // Quick check on the concurrent map first, with minimal locking.
        //以最快的速度从缓存中去检索,缩小检索范围
        // 首先是从mergedBeanDefinitions缓存中通过beanName去获取RootBeanDefinition,如果存在则返回.
        RootBeanDefinition mbd = this.mergedBeanDefinitions.get(beanName);
        if (mbd != null) {
            return mbd;
        }
        //获取RootBeanDefinition
        //如果返回的子beanDefinition的话,递归合并beanDefinition相关属性
        // 不存在的话,调用getMergedBeanDefinition方法获取,如果获取到的是子beanDefinition的话进行合并相关属性,这里关于如何合并的过程不再细说:
        return getMergedBeanDefinition(beanName, getBeanDefinition(beanName));
    }

    protected RootBeanDefinition getMergedBeanDefinition(String beanName, BeanDefinition bd) {
        return getMergedBeanDefinition(beanName, bd, null);
    }

    protected RootBeanDefinition getMergedBeanDefinition(String beanName, BeanDefinition bd, @Nullable BeanDefinition containingBd) {
        RootBeanDefinition mbd = null;
        if (containingBd == null) {
            mbd = this.mergedBeanDefinitions.get(beanName);
        }
        this.mergedBeanDefinitions.put(beanName, mbd);
        return mbd;
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);
}
