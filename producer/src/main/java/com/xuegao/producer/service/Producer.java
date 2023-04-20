package com.xuegao.producer.service;

import com.xuegao.producer.ProducerApplication;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class Producer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        int id = 0;
        while (id < 10) {
            System.out.println(" =======  ");
            rabbitTemplate.convertAndSend(ProducerApplication.TOPIC_EXCHANGE_NAME, "foo.bar.baz", "Hello from RabbitMQ!");
            TimeUnit.SECONDS.sleep(3);
            id++;
        }
    }

}
