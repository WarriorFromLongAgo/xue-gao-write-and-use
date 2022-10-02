package spring.beans.factory.support;

import com.sun.istack.internal.Nullable;
import spring.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanDefinition implements BeanDefinition, Cloneable {

    /**
     * Constant for the default scope name: {@code ""}, equivalent to singleton
     * status unless overridden from a parent bean definition (if applicable).
     */
    public static final String SCOPE_DEFAULT = "";
    @Nullable
    private volatile Object beanClass;
    @Nullable
    private String scope = SCOPE_DEFAULT;


    @Override
    public void setBeanClassName(@Nullable String beanClassName) {
        this.beanClass = beanClassName;
    }

    @Override
    @Nullable
    public String getBeanClassName() {
        Object beanClassObject = this.beanClass;
        if (beanClassObject instanceof Class) {
            return ((Class<?>) beanClassObject).getName();
        }
        else {
            return (String) beanClassObject;
        }
    }

    /**
     * Specify the class for this bean.
     */
    public void setBeanClass(@Nullable Class<?> beanClass) {
        this.beanClass = beanClass;
    }

    public Class<?> getBeanClass() throws IllegalStateException {
        Object beanClassObject = this.beanClass;
        if (beanClassObject == null) {
            throw new IllegalStateException("No bean class specified on bean definition");
        }
        if (!(beanClassObject instanceof Class)) {
            throw new IllegalStateException(
                    "Bean class name [" + beanClassObject + "] has not been resolved into an actual Class");
        }
        return (Class<?>) beanClassObject;
    }

    @Override
    public void setScope(@Nullable String scope) {
        this.scope = scope;
    }

    /**
     * Return the name of the target scope for the bean.
     */
    @Override
    @Nullable
    public String getScope() {
        return this.scope;
    }

    @Override
    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(this.scope) || SCOPE_DEFAULT.equals(this.scope);
    }




}
