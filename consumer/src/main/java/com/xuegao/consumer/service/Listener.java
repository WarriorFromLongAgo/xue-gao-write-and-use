package com.xuegao.consumer.service;

import com.xuegao.consumer.ConsumerApplication;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    // durable 表示队列是否持久化
    // autoDelete 表示没有消费者之后，队列是否自动删除
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = ConsumerApplication.QUEUE_NAME, durable = "false", autoDelete = "false"),
            exchange = @Exchange(value = ConsumerApplication.TOPIC_EXCHANGE_NAME, type = ExchangeTypes.TOPIC),
            key = "foo.bar.#")
    )
    public void listenerMessage(String message) {
        System.out.println(message);
    }

}