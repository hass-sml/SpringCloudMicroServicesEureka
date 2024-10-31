package org.chaimaa.reviewservice.dao;

import org.chaimaa.reviewservice.domain.Review;
import org.chaimaa.reviewservice.dto.responses.ReviewResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<Review, Long>{
    List<Review> getReviewsByProductId(long productId);
}


