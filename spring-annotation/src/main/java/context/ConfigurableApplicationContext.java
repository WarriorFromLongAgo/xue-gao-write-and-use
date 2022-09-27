package context;

import beans.factory.config.ConfigurableListableBeanFactory;

public interface ConfigurableApplicationContext extends ApplicationContext{


    ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException;
}
