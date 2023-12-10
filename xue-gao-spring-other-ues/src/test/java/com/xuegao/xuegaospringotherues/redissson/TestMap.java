package com.xuegao.xuegaospringotherues.redissson;


import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class TestMap {

    @Test
    public void contextLoads() throws InterruptedException {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");

        RedissonClient redisson = Redisson.create(config);
        RMap<Object, Object> hashmap = redisson.getMap("redisKey");
        hashmap.put("hashKey_____11", "hashMap1");
//        TimeUnit.SECONDS.sleep(10);
        hashmap.put("hashKey_____22", "hashMap2");
        hashmap.put("hashKey_____33", "hashMap3");

    }
}
