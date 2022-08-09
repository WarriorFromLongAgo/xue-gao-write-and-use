package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationPreparedEventTest implements ApplicationListener<MyApplicationPreparedEventTest.MyApplicationPreparedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationPreparedEventTest.class);

    @Override
    public void onApplicationEvent(MyApplicationPreparedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationPreparedEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationPreparedEvent extends ApplicationPreparedEvent {

        private String name;

        /**
         * Create a new {@link ApplicationPreparedEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         * @param context     the ApplicationContext about to be refreshed
         */
        public MyApplicationPreparedEvent(SpringApplication application, String[] args,
                                          ConfigurableApplicationContext context, String name) {
            super(application, args, context);
            this.name = name;
        }
    }
}

