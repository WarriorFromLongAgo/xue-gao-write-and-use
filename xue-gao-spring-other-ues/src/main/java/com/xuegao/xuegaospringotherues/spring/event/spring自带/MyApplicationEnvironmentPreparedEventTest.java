package com.xuegao.xuegaospringotherues.spring.event.spring自带;

import com.alibaba.fastjson2.JSON;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MyApplicationEnvironmentPreparedEventTest implements ApplicationListener<MyApplicationEnvironmentPreparedEventTest.MyApplicationEnvironmentPreparedEvent> {
    private static final Logger log = LoggerFactory.getLogger(MyApplicationEnvironmentPreparedEvent.class);

    @Override
    public void onApplicationEvent(MyApplicationEnvironmentPreparedEvent event) {
        System.out.println("[xuegao_Spring_Boot_Demo][MyApplicationEnvironmentPreparedEventTest][onApplicationEvent][event=" + JSON.toJSONString(event));
    }

    @Getter
    @Setter
    public static class MyApplicationEnvironmentPreparedEvent extends ApplicationEnvironmentPreparedEvent {

        private String name;

        /**
         * Create a new {@link ApplicationEnvironmentPreparedEvent} instance.
         *
         * @param application the current application
         * @param args        the arguments the application is running with
         * @param environment the environment that was just created
         */
        public MyApplicationEnvironmentPreparedEvent(SpringApplication application, String[] args,
                                                     ConfigurableEnvironment environment,
                                                     String name) {
            super(application, args, environment);
            this.name = name;
        }
    }
}

