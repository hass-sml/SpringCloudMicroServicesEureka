package org.kenmasml.recommendationservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.kenmasml.recommendationservice.dao")
@ComponentScan({"org.kenmasml.recommendationservice.service", "org.kenmasml.recommendationservice.controller"})
@EntityScan("org.kenmasml.recommendationservice.domain")
public class RecommendationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }

}
