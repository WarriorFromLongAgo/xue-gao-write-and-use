package com.xuegao.springbean.beanextend;

import com.xuegao.springbean.util.OnlyPrintUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Bean1040_PostConstruct {

    @PostConstruct
    public void postConstruct() {
        OnlyPrintUtil.print(getClass(), "postConstruct");
    }

    @PreDestroy
    public void PreDestroy() {
        OnlyPrintUtil.print(getClass(), "PreDestroy");
    }
}
