package com.xuegao.natsio_demo;

import io.nats.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

class ServerTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        // publish
        Connection nc = Nats.connect("nats://127.0.0.1:4222");
        // Subscribe
        Subscription sub = nc.subscribe("updates");

        // Read a message
        Message msg = sub.nextMessage(Duration.ZERO);

        String str = new String(msg.getData(), StandardCharsets.UTF_8);
        System.out.println(str);

        // Close the connection
        // nc.close();

        // TimeUnit.SECONDS.sleep(3);
    }

}
