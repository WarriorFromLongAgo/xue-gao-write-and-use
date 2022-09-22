package com.xuegao.springbean.beanextend;

import org.springframework.beans.factory.DisposableBean;

public class Bean13_DisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("[bean extend][Bean13_DisposableBean] destroy");
    }
}
