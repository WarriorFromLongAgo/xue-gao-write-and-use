package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
public class Bean110_SmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        OnlyPrintUtil.print(getClass(), "afterSingletonsInstantiated");
    }
}
