package org.chaimaa.reviewservice.service;

import jakarta.annotation.PostConstruct;
import org.chaimaa.reviewservice.dao.ReviewDao;
import org.chaimaa.reviewservice.domain.Review;
import org.chaimaa.reviewservice.dto.requests.ReviewRequest;
import org.chaimaa.reviewservice.dto.responses.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    @PostConstruct
    public void checkReviewDao() {
        System.out.println("ReviewDao initialized: " + reviewDao);
    }
    @Override
    public long addReview(ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setAuthor(reviewRequest.getAuthor());
        review.setSubject(reviewRequest.getSubject());
        review.setContent(reviewRequest.getContent());
        reviewDao.save(review);
        return review.getReviewId();
    }

    @Override
    public ReviewResponse getReviewById(long reviewId) {
        ReviewResponse reviewResponse = new ReviewResponse();
        Optional<Review> review = reviewDao.findById(reviewId);
        if(review.isPresent()){
            Review rev = review.get();
            reviewResponse.setReviewId(rev.getReviewId());
            reviewResponse.setSubject(rev.getSubject());
            reviewResponse.setContent(rev.getContent());
            reviewResponse.setAuthor(rev.getAuthor());
        } else{
            throw new RuntimeException("Review "+reviewId+" not found");
        }
        return reviewResponse;
    }
    public List<ReviewResponse> getReviewsByProductId(long productId) {
        List<ReviewResponse> reviewResponse = new ArrayList<>();
        List<Review> reviews = reviewDao.getReviewsByProductId(productId);
        for(Review review : reviews){
            ReviewResponse rev = new ReviewResponse();
            rev.setReviewId(review.getReviewId());
            rev.setSubject(review.getSubject());
            rev.setContent(review.getContent());
            rev.setAuthor(review.getAuthor());
            reviewResponse.add(rev);
        }

        return reviewResponse;
    }


}
