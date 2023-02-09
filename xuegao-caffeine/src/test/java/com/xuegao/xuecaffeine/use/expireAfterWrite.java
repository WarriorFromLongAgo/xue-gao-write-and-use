package com.xuegao.xuecaffeine.use;

import com.github.benmanes.caffeine.cache.*;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

public class expireAfterWrite {
    public static void main(String[] args) {
        //创建guava cache
        LoadingCache<String, String> cache = Caffeine.newBuilder()
                //cache的初始容量
                .initialCapacity(1)
                //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
                .maximumSize(4)
                // 写入后隔段时间过期,设置写缓存后n秒钟过期
                .expireAfterWrite(5, TimeUnit.SECONDS)
                // 访问后隔断时间过期,设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                // .expireAfterAccess(5, TimeUnit.SECONDS)
                // 写入后隔断时间刷新,设置写缓存后n秒钟刷新
                // .refreshAfterWrite(10, TimeUnit.SECONDS)
                // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {
                        System.out.println("removalListener key:" + o + " value:" + o2 + " cause:" + removalCause);
                    }
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public @Nullable String load(@NonNull String key) throws Exception {
                        return "获取不到的时候的对象返参";
                    }
                });
        cache.put("key", "value");
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(4);
                String key = cache.get("key");
                System.out.println(key);

                // 如果只是get，不put，那么是没用的。还是会到了时间自动删除
                // cache.put("key", "value");
                // 刷新是删除所有的缓存
                // cache.refresh("key");
                System.out.println("========================================");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
