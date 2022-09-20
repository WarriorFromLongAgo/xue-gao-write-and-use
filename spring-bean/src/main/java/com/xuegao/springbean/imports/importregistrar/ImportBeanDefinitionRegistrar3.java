package com.xuegao.springbean.imports.importregistrar;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

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
    }
}
