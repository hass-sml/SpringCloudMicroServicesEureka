package org.kenmasml.recommendationservice.dao;


import org.kenmasml.recommendationservice.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationDao extends JpaRepository<Recommendation, Long>{
    public List<Recommendation> getRecommendationsByProductId(long productId);
}


