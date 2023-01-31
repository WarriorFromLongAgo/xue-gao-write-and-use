package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class Bean1010_BeanNameAware implements BeanNameAware {
    public Bean1010_BeanNameAware() {
        OnlyPrintUtil.print(getClass(), "Bean8_BeanNameAware");
    }

    @Override
    public void setBeanName(String name) {
        OnlyPrintUtil.print(getClass(), "setBeanName === " + name);
    }
}
