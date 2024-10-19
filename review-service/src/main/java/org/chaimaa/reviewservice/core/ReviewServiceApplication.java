package org.chaimaa.reviewservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("org.chaimaa.reviewservice.dao")
@ComponentScan({"org.chaimaa.reviewservice.service", "org.chaimaa.reviewservice.controller"})
@EntityScan("org.chaimaa.reviewservice.domain")

public class ReviewServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReviewServiceApplication.class, args);
    }

}
