package test;

import spring.beans.factory.config.BeanDefinition;
import spring.beans.factory.support.RootBeanDefinition;
import spring.context.support.GenericApplicationContext;
import test.bean.UserService;

public class ApiTest {
    public static void main(String[] args) {
        // 1.初始化 BeanFactory
        GenericApplicationContext beanFactory = new GenericApplicationContext();

        // 2.注入bean
        BeanDefinition beanDefinition = new RootBeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        beanFactory.refresh();

        // 3.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();
    }
}
