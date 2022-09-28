package spring.beans.factory.support;

public class RootBeanDefinition extends AbstractBeanDefinition {
    private Object bean;

    public RootBeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
