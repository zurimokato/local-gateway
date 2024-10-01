package com.local.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder
                .routes()
                .route(r -> r.path("/local/api/v1/products/**").uri("lb://ms-product"))
                .route(r -> r.path("/local/api/v1/stores/**").uri("lb://ms-store"))
                .route(r -> r.path("/local/api/v1/clients/**").uri("lb://ms-client"))
                .route(r->r.path("/local/api/v1/orders/**").uri("lb://ms-order"))
                .build();
    }

}
