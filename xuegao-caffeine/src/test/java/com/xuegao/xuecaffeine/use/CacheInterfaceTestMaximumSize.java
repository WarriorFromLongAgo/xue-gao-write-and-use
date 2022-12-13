package com.xuegao.xuecaffeine.use;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @author fjm
 * @date 2022年11月18日 17:46
 */
public class CacheInterfaceTestMaximumSize {

    public static void main(String[] args) throws Exception {
        //创建guava cache
        Cache<String, String> cache = Caffeine.newBuilder()
                //cache的初始容量
                .initialCapacity(1)
                //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
                .maximumSize(2)
                // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {
                        System.out.println("removalListener key:" + o + " value:" + o2 + " cause:" + removalCause);
                    }
                })
                .evictionListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object key, @Nullable Object value, @NonNull RemovalCause cause) {
                        System.out.println("evictionListener key:" + key + " value:" + value + " cause:" + cause);
                    }
                })
                .build();
        // 往缓存写数据
        cache.put("1", "v1");
        cache.put("2", "v2");
        cache.put("3", "v3");
        // cache.cleanUp();
        TimeUnit.SECONDS.sleep(100);
    }
}
