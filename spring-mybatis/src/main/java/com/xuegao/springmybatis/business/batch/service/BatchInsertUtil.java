package com.xuegao.springmybatis.business.batch.service;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;

@Service
public class BatchInsertUtil {

    public <T> void batchSplitInsert(List<T> list, int batchSize, Consumer<List<T>> insertFunc) {
        if (list.size() > batchSize) {
            List<List<T>> partition = Lists.partition(list, batchSize);
            partition.forEach(insertFunc);
        } else {
            insertFunc.accept(list);
        }
    }

    // 作者：BeerBear
    // 链接：https://juejin.cn/post/7048822955983241229
    // 来源：稀土掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
