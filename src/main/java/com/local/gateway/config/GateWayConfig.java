package com.local.gateway.config;

import com.local.gateway.filter.AuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GateWayConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder, AuthenticationFilter authenticationFilter) {
        return builder
                .routes()
                .route(r -> r.path("/local/api/v1/products/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-product"))
                .route(r -> r.path("/local/api/v1/stores/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-store"))
                .route(r -> r.path("/local/api/v1/clients/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-client"))
                .route(r->r.path("/local/api/v1/orders/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-order"))
                .route(r->r.path("/local/api/v1/notifications/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-notification"))
                .route(r->r.path("/local/api/v1/menus/**")
                        .filters(f->
                                f.filter(authenticationFilter.apply(new AuthenticationFilter.Config())))
                        .uri("lb://ms-menu"))

                .build();
    }

}
