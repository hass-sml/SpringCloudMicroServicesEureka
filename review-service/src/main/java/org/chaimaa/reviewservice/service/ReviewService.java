package org.chaimaa.reviewservice.service;

import org.chaimaa.reviewservice.dto.requests.ReviewRequest;
import org.chaimaa.reviewservice.dto.responses.ReviewResponse;

import java.util.List;

public interface ReviewService {
    public long addReview(ReviewRequest reviewRequest);
    public ReviewResponse getReviewById(long id);
    public List<ReviewResponse> getReviewsByProductId(long productId);
}
