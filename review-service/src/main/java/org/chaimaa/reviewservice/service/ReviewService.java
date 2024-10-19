package org.chaimaa.reviewservice.service;

import org.chaimaa.reviewservice.dto.requests.ReviewRequest;
import org.chaimaa.reviewservice.dto.responses.ReviewResponse;

public interface ReviewService {
    public long addReview(ReviewRequest reviewRequest);
//    public void updateReview();
//    public void deleteReview();
    public ReviewResponse getReviewById(long id);
}
