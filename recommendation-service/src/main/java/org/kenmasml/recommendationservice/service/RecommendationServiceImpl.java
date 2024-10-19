package org.kenmasml.recommendationservice.service;

import org.kenmasml.recommendationservice.dao.RecommendationDao;
import org.kenmasml.recommendationservice.domain.Recommendation;
import org.kenmasml.recommendationservice.dto.requests.RecommendationRequest;
import org.kenmasml.recommendationservice.dto.responses.RecommendationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecommendationServiceImpl implements RecommendationService {
    @Autowired
    private RecommendationDao recommendationDao;

    @Override
    public long addRecommendation(RecommendationRequest recommendationRequest) {
        Recommendation recommendation = new Recommendation();
        recommendation.setAuthor(recommendationRequest.getAuthor());
        recommendation.setContent(recommendationRequest.getContent());
        recommendation.setRate(recommendationRequest.getRate());
        recommendationDao.save(recommendation);
        return recommendation.getRecommendationId();
    }
    @Override
    public void updateRecommendations() {
        System.out.println("sdfsdjfjn");
    }

    @Override
    public void deleteRecommendation() {
    }
    @Override
    public RecommendationResponse findRecommendationById(long recommendationId) {
        RecommendationResponse recommendationResponse = new RecommendationResponse();
        Optional<Recommendation> recommendation = recommendationDao.findById(recommendationId);
        if(recommendation.isPresent()) {
            Recommendation recommend = recommendation.get();
            recommendationResponse.setRecommendationId(recommend.getRecommendationId());
            recommendationResponse.setRate(recommend.getRate());
            recommendationResponse.setAuthor(recommend.getAuthor());
            recommendationResponse.setContent(recommend.getContent());
        }else{
            throw new RuntimeException("Recommendation "+recommendationId+" not found");
        }

        return recommendationResponse;
    }
}
