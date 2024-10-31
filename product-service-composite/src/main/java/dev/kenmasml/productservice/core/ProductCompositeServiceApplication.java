package dev.kenmasml.productservice.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"dev.kenmasml.productservice.service", "dev.kenmasml.productservice.controller"})
@EntityScan("dev.kenmasml.productservice.domain")
@EnableFeignClients("dev.kenmasml.productservice.clients")

public class ProductCompositeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductCompositeServiceApplication.class, args);
    }

}
