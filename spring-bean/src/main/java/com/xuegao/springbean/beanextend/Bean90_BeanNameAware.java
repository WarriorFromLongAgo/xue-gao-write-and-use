package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Bean90_BeanNameAware implements BeanNameAware {
    public Bean90_BeanNameAware() {
        OnlyPrintUtil.print(getClass(), "Bean8_BeanNameAware");
    }

    @Override
    public void setBeanName(String name) {
        OnlyPrintUtil.print(getClass(), "setBeanName");
    }
}
