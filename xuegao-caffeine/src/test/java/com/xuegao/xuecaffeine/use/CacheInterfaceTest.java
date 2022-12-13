package com.xuegao.xuecaffeine.use;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import com.github.benmanes.caffeine.cache.RemovalListener;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.TimeUnit;

/**
 * @author fjm
 * @date 2022年11月18日 17:46
 */
public class CacheInterfaceTest {

    public static void main(String[] args) throws Exception {
        //创建guava cache
        Cache<String, String> cache = Caffeine.newBuilder()
                //cache的初始容量
                .initialCapacity(1)
                //cache最大缓存数,设置缓存最大条目数，超过条目则触发回收。
                .maximumSize(4)
                // 设置缓存最大权重，设置权重是通过weigher方法，
                // 需要注意的是权重也是限制缓存大小的参数，并不会影响缓存淘汰策略，也不能和maximumSize方法一起使用。
                // .maximumWeight(10)
                // 将key设置为弱引用，在GC时可以直接淘汰
                // .weakKeys()
                // 将value设置为弱引用，在GC时可以直接淘汰
                // .weakValues()
                // 将value设置为软引用，在内存溢出前可以直接淘汰
                // .softValues()
                // 写入后隔段时间过期,设置写缓存后n秒钟过期
                .expireAfterWrite(17, TimeUnit.SECONDS)
                // 访问后隔断时间过期,设置读写缓存后n秒钟过期,实际很少用到,类似于expireAfterWrite
                //.expireAfterAccess(17, TimeUnit.SECONDS)
                // 写入后隔断时间刷新,设置写缓存后n秒钟刷新
                // .refreshAfterWrite(10, TimeUnit.SECONDS)
                // 缓存淘汰监听器，配置监听器后，每个条目淘汰时都会调用该监听器
                .removalListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object o, @Nullable Object o2, @NonNull RemovalCause removalCause) {
                        System.out.println("removalListener key:" + o + " value:" + o2 + " cause:" + removalCause);
                    }
                })
                // 指定运行异步任务时要使用的线程池。
                // .executor()
                // 定期清空数据的一个机制
                // .scheduler()
                // 不知道这个有什么用
                .evictionListener(new RemovalListener<Object, Object>() {
                    @Override
                    public void onRemoval(@Nullable Object key, @Nullable Object value, @NonNull RemovalCause cause) {
                        System.out.println("evictionListener key:" + key + " value:" + value + " cause:" + cause);
                    }
                })
                .build(new CacheLoader<String, String>() {
                    @Override
                    public @Nullable String load(@NonNull String key) throws Exception {
                        return "获取不到的时候的对象返参";
                    }
                });
        String key = "key";
        // 往缓存写数据
        cache.put(key, "v");

        // 获取value的值，如果key不存在，获取value后再返回
        String value = cache.get(key, CacheInterfaceTest::getValueFromDB);
        System.out.println(value);
        // 删除key
        cache.invalidate(key);
        // 获取value的值，如果key不存在，获取value后再返回
        String value2 = cache.get(key, CacheInterfaceTest::getValueFromDB);
        System.out.println(value2);
        // 删除key
        cache.invalidate(key);
        // 获取value的值，如果key不存在，获取value后再返回
        // String value3 = cache.get(key, null);
        // System.out.println(value3);

    }

    private static String getValueFromDB(String key) {
        return "v";
    }
}
