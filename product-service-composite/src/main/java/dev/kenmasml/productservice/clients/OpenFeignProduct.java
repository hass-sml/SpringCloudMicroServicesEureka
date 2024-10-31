package dev.kenmasml.productservice.clients;

import dev.kenmasml.productservice.dto.responses.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "/api/products", value="product-service")
public interface OpenFeignProduct {
    @GetMapping("/{id}")
    ProductResponse getProductById(@PathVariable("id") long id);
}