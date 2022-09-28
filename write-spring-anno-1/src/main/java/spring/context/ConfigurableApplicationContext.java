package spring.context;

import spring.beans.factory.config.ConfigurableListableBeanFactory;
import spring.context.context.ApplicationContext;

public interface ConfigurableApplicationContext extends ApplicationContext {

    void refresh();

    ConfigurableListableBeanFactory getBeanFactory();
}
