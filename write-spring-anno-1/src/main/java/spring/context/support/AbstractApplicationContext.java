package spring.context.support;

import spring.beans.factory.config.ConfigurableListableBeanFactory;
import spring.context.ConfigurableApplicationContext;

public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {

    @Override
    public void refresh() {

        // 返回一个factory 为什么需要返回一个工厂
        // 因为要对工厂进行初始化
        // Tell the subclass to refresh the internal bean factory.
        // 这里默认返回的是 GenericApplicationContext 里面的东西，因为就一个实现类
        ConfigurableListableBeanFactory beanFactory = obtainFreshBeanFactory();

        // 实现bean的扫描，将 class 变成 beanDefinition。
        // 设置执行自定义的ProcessBeanFactory 和spring内部自己定义的，在spring的环境中去执行已经被注册的 factoryBean processors
        // Invoke factory processors registered as beans in the context.
        invokeBeanFactoryPostProcessors(beanFactory);


        // 实例化单列的bean对象，将 BeanDefinition 变成 bean（重要）
        // Instantiate all remaining (non-lazy-init) singletons.
        finishBeanFactoryInitialization(beanFactory);
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
    public <T> T getBean(Class<T> requiredType) {
        return getBeanFactory().getBean(requiredType);
    }

    @Override
    public abstract ConfigurableListableBeanFactory getBeanFactory();

    /**
     * Tell the subclass to refresh the internal bean factory.
     *
     * @return the fresh BeanFactory instance
     * @see #getBeanFactory()
     */
    protected ConfigurableListableBeanFactory obtainFreshBeanFactory() {
        // 这里默认返回的是 GenericApplicationContext 里面的东西，因为就一个实现类
        return getBeanFactory();
    }

    /***
     * 将 class 变成 BeanDefinition
     * invokeBeanFactoryPostProcessors
     *
     * @param beanFactory:
     * @author xuegao
     * @date 2022/9/29 23:29
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {

    }

    /**
     * 将 BeanDefinition 变成 bean
     * finishBeanFactoryInitialization
     *
     * @param beanFactory:
     * @author xuegao
     * @date 2022/9/29 23:29
     */
    protected void finishBeanFactoryInitialization(ConfigurableListableBeanFactory beanFactory) {

        beanFactory.preInstantiateSingletons();
    }
}
