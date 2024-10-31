package org.kenmasml.recommendationservice.service;

import org.kenmasml.recommendationservice.dao.RecommendationDao;
import org.kenmasml.recommendationservice.domain.Recommendation;
import org.kenmasml.recommendationservice.dto.requests.RecommendationRequest;
import org.kenmasml.recommendationservice.dto.responses.RecommendationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    public List<RecommendationResponse> getRecommendationsByProductId(long productId) {
        List<Recommendation> recommendations = recommendationDao.getRecommendationsByProductId(productId);
        List<RecommendationResponse> recommendationResponses =  new ArrayList<>();

        for(Recommendation recommendation: recommendations) {
            RecommendationResponse recommendationResponse = new RecommendationResponse();
            recommendationResponse.setRecommendationId(recommendation.getRecommendationId());
            recommendationResponse.setRate(recommendation.getRate());
            recommendationResponse.setAuthor(recommendation.getAuthor());
            recommendationResponse.setContent(recommendation.getContent());
            recommendationResponses.add(recommendationResponse);
        }
        return recommendationResponses;
    }
}
