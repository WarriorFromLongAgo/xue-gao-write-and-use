package com.xuegao.xuegaogateway.config.route;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    /**
     * 配置了一个id为path_mxn的路由规则
     * 当访问地址 http://localhost:9999/mxn/**
     * 就会转发到 http://localhost:9001/nacos-provider/mxn /任何地址
     */
    @Bean
    public RouteLocator gateWayConfigInfo(RouteLocatorBuilder routeLocatorBuilder) {
        // 构建多个路由routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 具体路由地址
        routes
                .route("feign-client-service", r -> r.path("/feign-client/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://feign-client-service")
                );

        // 作者：古时的风筝
        // 链接：https://juejin.cn/post/6844904094822318087
        // 来源：稀土掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        return routes.build();
    }
}
