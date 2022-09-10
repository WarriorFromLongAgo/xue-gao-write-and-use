package com.xuegao.xuegaogateway.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    private static final Logger log = LoggerFactory.getLogger(MyGlobalFilter.class);

    private static final String START_TIME = "requestTime";

    /**
     * 过滤器执行顺序，数值越小，优先级越高
     * getOrder
     *
     * @return int
     * @author xuegao
     * @date 2022/9/10 16:38
     */
    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        exchange.getAttributes().put(START_TIME, System.currentTimeMillis());

        ServerHttpRequest request = exchange.getRequest();
        //获取请求uri
        String uriPath = request.getURI().getPath();

        log.info("[xue-gao-write-and-use][MyGlobalFilter][filter][Method={}][host={}][uriPath={}][query={}]",
                request.getMethod().name(), request.getURI().getHost(), uriPath, request.getQueryParams());
        uriPath = uriPath.substring(uriPath.indexOf("/", 1));

        //如果在白名单的URL，请求则放行
        // if (urlWhiteListConfig.getPathList().contains(uriPath)) {
        //     return chainFilter(exchange, chain);
        // }
        //请求头中获取令牌
        String token = request.getHeaders().getFirst("token");

        //判断请求头中是否有令牌
        // if (StringUtils.isEmpty(token)) {
        //     return responseWrite(exchange, "没有权限，请登录");
        // }
        //如果请求头中有令牌则解析令牌
//         try {
//             Claims claims = JwtUtil.parseJWT(token);
//             LoginInfoEntity loginInfo = JSON.parseObject(claims.getSubject(), LoginInfoEntity.class);
//             if (redisUtil.get(loginInfo.getName()) == null) {
//                 return responseWrite(exchange, "鉴权失效，请重新登录");
//             }
//
//             String tokenStr = (String) redisUtil.get(loginInfo.getName());
//             if (!token.equals(tokenStr)) {
//                 return responseWrite(exchange, "鉴权失效，请重新登录");
//             }
//             //刷新缓存时间
// //            redisUtil.expire(loginInfo.getName(), 30 * 60);
//         } catch (Exception e) {
//             log.error("jwt解析异常：", e);
//             return responseWrite(exchange, "没有权限，请登录");
//         }

        //放行
        return chainFilter(exchange, chain);
    }

    public Mono<Void> chainFilter(ServerWebExchange exchange, GatewayFilterChain chain) {
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            Long startTime = exchange.getAttribute(START_TIME);
            if (startTime != null) {
                long executeTime = System.currentTimeMillis() - startTime;
                log.info("[xue-gao-write-and-use][MyGlobalFilter][chainFilter][{} = executeTime = {} ms]",
                        exchange.getRequest().getURI().getRawPath(), executeTime);
            }
        }));
    }
}
