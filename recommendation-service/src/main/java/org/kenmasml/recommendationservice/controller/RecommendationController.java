package org.kenmasml.recommendationservice.controller;

import lombok.*;
import org.kenmasml.recommendationservice.dto.requests.RecommendationRequest;
import org.kenmasml.recommendationservice.dto.responses.RecommendationResponse;
import org.kenmasml.recommendationservice.service.RecommendationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/recommendations")
public class RecommendationController {

    private RecommendationService recommendationService;

    @PostMapping
    public ResponseEntity<Long> addRecommendation(@RequestBody RecommendationRequest recommendationRequest) {
        long recommendationId = recommendationService.addRecommendation(recommendationRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(recommendationId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationResponse> getRecommendationById(@PathVariable("id") long id) {
        RecommendationResponse recommendationResponse = recommendationService.findRecommendationById(id);
        return  ResponseEntity.ok().body(recommendationResponse);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<RecommendationResponse>> getRecommendationsByProductId(@PathVariable("productId") long productId) {
        List<RecommendationResponse> recommendationResponse = recommendationService.getRecommendationsByProductId(productId);
        return  ResponseEntity.ok().body(recommendationResponse);
    }
}

