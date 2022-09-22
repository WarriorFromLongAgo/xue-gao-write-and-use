package com.xuegao.springbean.imports.importregistrar;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBeanDefinitionRegistrar3 implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableService.class.getName(), true);
        // String name = (String) map.get("name");
        // BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
        //         .rootBeanDefinition(ServiceC.class)
        //         //增加构造参数
        //         .addConstructorArgValue(name);
        //注册Bean
        // registry.registerBeanDefinition("serviceC", beanDefinitionBuilder.getBeanDefinition());
        System.out.println("ImportBeanDefinitionRegistrar3 registerBeanDefinitions");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(ImportTestService3.class);
        registry.registerBeanDefinition("ImportTestService3", beanDefinitionBuilder.getBeanDefinition());

        // GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        // beanDefinition.setBeanClass(PigxResourceServerConfigurerAdapter.class);
        // registry.registerBeanDefinition(SecurityConstants.RESOURCE_SERVER_CONFIGURER, beanDefinition);

        // @Import({PigxSecurityBeanDefinitionRegistrar.class})
        // public @interface EnablePigxResourceServer {
        // }

        // 定义一个bean：Service1
        // BeanDefinition service1BeanDinition = BeanDefinitionBuilder.genericBeanDefinition(Service1.class).getBeanDefinition();
        // // 注册bean
        // registry.registerBeanDefinition("service1", service1BeanDinition);
        // //定义一个bean：Service2，通过addPropertyReference注入service1
        // BeanDefinition service2BeanDinition = BeanDefinitionBuilder.genericBeanDefinition(Service2.class).
        // addPropertyReference("service1", "service1").
        // getBeanDefinition();
        // //注册bean
        // registry.registerBeanDefinition("service2",service2BeanDinition);`

    }
}
