package dev.kenmasml.productservice.clients;

import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;


@LoadBalancerClient(value="recommendation-service")
public class LoadBalancerRecommendation {
    @Bean
    @LoadBalanced
    Feign.Builder feignBuilder() {
        return Feign.builder();
    }
}