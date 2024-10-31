package dev.kenmasml.productservice.clients;


import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(path = "/api/recommendations", value="recommendation-service")
public interface OpenFeignRecommendation {
    @GetMapping("/product/{productId}")
    public List<RecommendationResponse> getRecommendationsByProductId(@PathVariable("productId") long productId);
}