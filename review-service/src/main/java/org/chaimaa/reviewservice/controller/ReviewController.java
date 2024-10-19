package org.chaimaa.reviewservice.controller;

import lombok.AllArgsConstructor;
import org.chaimaa.reviewservice.dto.requests.ReviewRequest;
import org.chaimaa.reviewservice.dto.responses.ReviewResponse;
import org.chaimaa.reviewservice.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/api/reviews")
public class ReviewController {

    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Long> addReview(@RequestBody ReviewRequest reviewRequest) {
        long reviewId = reviewService.addReview(reviewRequest);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{id}")
                .buildAndExpand(reviewId)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewResponse> getReview(@PathVariable("id") long id) {
        ReviewResponse reviewResponse = reviewService.getReviewById(id);
        return  ResponseEntity.ok().body(reviewResponse);
    }
}

