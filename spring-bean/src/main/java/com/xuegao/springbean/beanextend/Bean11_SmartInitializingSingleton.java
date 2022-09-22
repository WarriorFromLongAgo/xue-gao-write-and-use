package com.xuegao.springbean.beanextend;

import org.springframework.beans.factory.SmartInitializingSingleton;

public class Bean11_SmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("[bean extend][Bean11_SmartInitializingSingleton][afterSingletonsInstantiated]");
    }
}
