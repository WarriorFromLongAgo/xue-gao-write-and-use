package com.xuegao.natsio_demo;

import io.nats.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

class ClientTests {

    @Test
    void contextLoads() throws IOException, InterruptedException {
        // publish
        Connection nc = Nats.connect("nats://127.0.0.1:4222");
        // Create a unique subject name
        String uniqueReplyTo = NUID.nextGlobal();
        System.out.println(uniqueReplyTo);
// Listen for a single response
        Subscription sub = nc.subscribe("updates");

// Read the reply
        Message msg = sub.nextMessage(Duration.ofSeconds(1));

// Use the response
        System.out.println(new String(msg.getData(), StandardCharsets.UTF_8));

// Close the connection
        nc.close();
    }

}
