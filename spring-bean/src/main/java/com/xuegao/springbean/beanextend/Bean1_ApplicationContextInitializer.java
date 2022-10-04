package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 要么在springboot run的时候添加，要么就在 META-INF/spring.factories 中配置
 */
public class Bean1_ApplicationContextInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        OnlyPrintUtil.print(getClass(), "initialize");
        // 调用时间点
        // SpringApplication.run()
        // SpringApplication.prepareContext
        // SpringApplication.applyInitializers

        // ApplicationContextInitializer initializer = (ApplicationContextInitializer)var2.next();
        // Class<?> requiredType = GenericTypeResolver.resolveTypeArgument(initializer.getClass(), ApplicationContextInitializer.class);
        // Assert.isInstanceOf(requiredType, context, "Unable to call initializer.");
        // initializer.initialize(context);
    }
}
