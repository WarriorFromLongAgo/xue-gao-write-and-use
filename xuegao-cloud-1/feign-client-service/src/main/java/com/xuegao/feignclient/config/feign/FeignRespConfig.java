package com.xuegao.feignclient.config.feign;

import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;

// @Configuration
public class FeignRespConfig {

    @Bean
    public Decoder feignDecoder(ObjectProvider<HttpMessageConverters> messageConverters) {
        return new OptionalDecoder((new ResponseEntityDecoder(new ResponseDecoder(new SpringDecoder(messageConverters)))));
    }

}
