package com.xuegao.springbean.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringUtils implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(SpringUtils.class);
    private static ApplicationContext ctx = null;

    public SpringUtils() {
    }

    public static Object getBean(String beanName) {
        if (ctx != null) {
            try {
                return ctx.getBean(beanName);
            } catch (Exception var2) {
                logger.warn("获取Bean失败！ beanName: " + beanName, var2);
                return null;
            }
        } else {
            return null;
        }
    }

    public static <T> T getBean(String beanName, Class<T> requiredType) {
        T result = null;
        if (ctx != null) {
            try {
                result = ctx.getBean(beanName, requiredType);
            } catch (Exception var4) {
                logger.warn("获取Bean失败！ beanName: " + beanName, var4);
            }
        }

        return result;
    }

    public static <T> T getBean(Class<T> requiredType) {
        T result = null;
        if (ctx != null) {
            try {
                result = ctx.getBean(requiredType);
            } catch (Exception var3) {
                logger.warn("获取Bean失败！", var3);
            }
        }

        return result;
    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ctx = applicationContext;
    }

}
