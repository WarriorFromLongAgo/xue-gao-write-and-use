package com.xuegao.feignclient.config.feign;

import com.xuegao.model.common.constant.Constant;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.UUID;

@Configuration
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        template.header("request-application-name", "feignclient");
        String traceId = UUID.randomUUID().toString().replace("-", "");
        template.header(Constant.TRACE_ID, traceId + "-feignclient");

        // 从header获取X-token
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attr = (ServletRequestAttributes) requestAttributes;
        if (Objects.nonNull(attr)) {
            HttpServletRequest request = attr.getRequest();
            // 网关传过来的 token
            String token = request.getHeader("x-auth-token");
            if (StringUtils.hasText(token)) {
                template.header("X-AUTH-TOKEN", token);
            }
        }
    }

}
