package com.xuegao.xuegaospringotherues.redissson;


import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestMap {

    @Test
    void contextLoads() {
        // 1. Create config object
        Config config = new Config();
        config.useClusterServers()
                // use "rediss://" for SSL connection
                .addNodeAddress("redis://127.0.0.1:7181");

        RedissonClient redisson = Redisson.create(config);
        RMap<Object, Object> hashmap = redisson.getMap("redisKey");
        hashmap.put("hashKey", "hashMap");

    }
}
