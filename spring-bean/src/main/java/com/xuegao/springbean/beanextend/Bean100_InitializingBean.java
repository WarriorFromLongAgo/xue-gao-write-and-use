package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Bean100_InitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        OnlyPrintUtil.print(getClass(), "afterPropertiesSet");
    }
}
