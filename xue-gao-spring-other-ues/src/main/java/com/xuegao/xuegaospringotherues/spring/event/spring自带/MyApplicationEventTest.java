package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationEventTest implements ApplicationListener<MyApplicationEventTest.MyApplicationEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationEvent extends ApplicationEvent {

        private Integer age;

        private String name;

        /**
         * 需要重写构造方法
         *
         * @param source
         * @param name
         * @param age
         */
        public MyApplicationEvent(Object source, String name, Integer age) {
            super(source);
            this.name = name;
            this.age = age;
        }
    }
}

