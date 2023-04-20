package com.xuegao.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication {
    public static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";

    public static final String QUEUE_NAME = "spring-boot";

    public static void main(String[] args) {
        SpringApplication.run(ProducerApplication.class, args);
    }

}
