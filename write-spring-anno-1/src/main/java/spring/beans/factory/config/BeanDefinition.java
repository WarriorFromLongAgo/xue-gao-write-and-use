package spring.beans.factory.config;

import com.sun.istack.internal.Nullable;

public interface BeanDefinition {
    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    void setBeanClassName(@Nullable String beanClassName);

    @Nullable
    String getBeanClassName();

    void setScope(@Nullable String scope);

    @Nullable
    String getScope();

    boolean isSingleton();

}