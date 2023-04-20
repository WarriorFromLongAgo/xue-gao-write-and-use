package com.xuegao.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

    public static final String TOPIC_EXCHANGE_NAME = "spring-boot-exchange";

    public static final String QUEUE_NAME = "spring-boot";

    // @Bean
    // Queue queue() {
    //     return new Queue(QUEUE_NAME);
    // }
    //
    // @Bean
    // TopicExchange exchange() {
    //     return new TopicExchange(TOPIC_EXCHANGE_NAME);
    // }
    //
    // @Bean
    // Binding binding(Queue queue, TopicExchange exchange) {
    //     return BindingBuilder.bind(queue).to(exchange).with("foo.bar.#");
    // }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

}
