package dev.kenmasml.productservice.clients;

import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(path = "/api/reviews", value="review-service")
public interface OpenFeignReview {
    @GetMapping("/product/{id}")
    public List<ReviewResponse> getReviewsByProductId(@PathVariable("id") long productId);
}