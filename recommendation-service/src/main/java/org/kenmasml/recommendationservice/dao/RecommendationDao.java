package org.kenmasml.recommendationservice.dao;


import org.kenmasml.recommendationservice.domain.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationDao extends JpaRepository<Recommendation, Long>{
}


