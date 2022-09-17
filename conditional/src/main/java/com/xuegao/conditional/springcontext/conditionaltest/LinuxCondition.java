package com.xuegao.conditional.springcontext.conditionaltest;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @Auther: lifq
 * @Description:
 */
public class LinuxCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // return context.getEnvironment().getProperty("os.name").contains("Linux");
        return true;
    }
}