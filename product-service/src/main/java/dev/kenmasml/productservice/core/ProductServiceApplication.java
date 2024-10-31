package dev.kenmasml.productservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("dev.kenmasml.productservice.dao")
@ComponentScan({"dev.kenmasml.productservice.service", "dev.kenmasml.productservice.controller"})
@EntityScan("dev.kenmasml.productservice.domain")

public class ProductServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
