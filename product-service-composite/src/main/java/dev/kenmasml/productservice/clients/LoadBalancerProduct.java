package dev.kenmasml.productservice.clients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value="product-service")
public class LoadBalancerProduct {
    @Bean
    @LoadBalanced
    Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}
