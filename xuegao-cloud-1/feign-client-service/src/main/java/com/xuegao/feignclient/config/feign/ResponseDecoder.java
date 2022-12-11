package com.xuegao.feignclient.config.feign;

import com.xuegao.core.model.Result;
import com.xuegao.util.JsonUtil;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ResponseDecoder implements Decoder {
    private final SpringDecoder decoder;

    public ResponseDecoder(SpringDecoder decoder) {
        this.decoder = decoder;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        Method method = response.request().requestTemplate().methodMetadata().method();
        //如果Feign接口的返回值不是 Response{code:0,...} 结构类型，并且远程响应又是这个结构
        boolean isNotClassFLag = method.getReturnType() != com.xuegao.core.model.Result.class;
        if (isNotClassFLag) {
            //构造一个这个结构类型
            Type newType =
                    new ParameterizedType() {
                        @Override
                        public Type[] getActualTypeArguments() {
                            return new Type[]{type};
                        }

                        @Override
                        public Type getRawType() {
                            return com.xuegao.core.model.Result.class;
                        }

                        @Override
                        public Type getOwnerType() {
                            return null;
                        }
                    };
            com.xuegao.core.model.Result<?> result = (com.xuegao.core.model.Result<?>) this.decoder.decode(response, newType);
            //只返回data
            return result.getData();
        } else {
            String s = response.body().toString();
            Result respUtil = JsonUtil.toClass(s, Result.class);
            return respUtil.getData();
        }
        // return this.decoder.decode(response, type);
    }

    // 作者：暮色妖娆丶
    // 链接：https://juejin.cn/post/7122412030312742926
    // 来源：稀土掘金
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
