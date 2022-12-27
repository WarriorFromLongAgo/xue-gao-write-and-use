package com.xuegao.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Value("${config}")
    private String config;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        Application application = new Application();
        log.info("[xue-gao-write-and-use][Application][main][config={}]", application.config);
    }


}
