package com.xuegao.xuegaogateway.config.route;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    /**
     * 配置了一个id为path_mxn的路由规则
     * 当访问地址 http://localhost:9999/mxn/**
     * 就会转发到 http://localhost:9001/nacos-provider/mxn /任何地址
     */
    // @Bean
    // public RouteLocator gateWayConfigInfo(RouteLocatorBuilder routeLocatorBuilder) {
    //     // 构建多个路由routes
    //     RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
    //     // 具体路由地址
    //     routes
    //             .route("hr", r -> r.path("/hr/**")
    //                     .uri("hr-service"))
    //             .build();
    //     // 返回所有路由规则
    //     return routes.build();
    // }


}
