package com.xuegao.xuegaospringotherues.spring.publish;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class MsgPublisher implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    // public void publish(String msg) {
    //     applicationContext.publishEvent(new MsgEvent(this, msg));
    // }
}