package dev.kenmasml.productservice.clients;

import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(path = "/api/reviews", value="review-service")
public interface OpenFeignReview {
    @GetMapping("/{id}")
    ReviewResponse getReviewById(@PathVariable("id") long id);
}