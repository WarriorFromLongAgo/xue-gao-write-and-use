package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 *
 */
public class Bean10_ImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 调用时间点
        // 在 spring 初始化 org.springframework.boot.autoconfigure.internalCachingMetadataReaderFactory 的时候
        // org.springframework.context.support.AbstractApplicationContext#invokeBeanFactoryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(beanFactory, getBeanFactoryPostProcessors());
        // PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors
        // PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors postProcessBeanDefinitionRegistry
        // ConfigurationClassPostProcessor.processConfigBeanDefinitions
        // ConfigurationClassBeanDefinitionReader.loadBeanDefinitions
        // ConfigurationClassBeanDefinitionReader.loadBeanDefinitionsFromRegistrars
        // registrars.forEach((registrar, metadata) ->
        //         registrar.registerBeanDefinitions(metadata, this.registry, this.importBeanNameGenerator));
        // ImportBeanDefinitionRegistrar.registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)

        // Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableService.class.getName(), true);
        // String name = (String) map.get("name");
        // BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder
        //         .rootBeanDefinition(ServiceC.class)
        //         //增加构造参数
        //         .addConstructorArgValue(name);
        //注册Bean
        // registry.registerBeanDefinition("serviceC", beanDefinitionBuilder.getBeanDefinition());
        OnlyPrintUtil.print(getClass(), "registerBeanDefinitions");
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.rootBeanDefinition(Bean11_ImportBeanDefinitionRegistrarConfig.Bean11_ImportBeanDefinitionRegistrarTestService.class);
        registry.registerBeanDefinition("Bean11_ImportBeanDefinitionRegistrarTestService", beanDefinitionBuilder.getBeanDefinition());

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
