package dev.kenmasml.productservice.clients;


import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "/api/recommendations", value="recommendation-service")
public interface OpenFeignRecommendation {
    @GetMapping("/{id}")
    RecommendationResponse getRecommendationById(@PathVariable("id") long id);
}