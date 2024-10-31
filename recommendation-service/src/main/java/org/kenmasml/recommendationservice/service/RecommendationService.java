package org.kenmasml.recommendationservice.service;

import org.kenmasml.recommendationservice.domain.Recommendation;
import org.kenmasml.recommendationservice.dto.requests.RecommendationRequest;
import org.kenmasml.recommendationservice.dto.responses.RecommendationResponse;

import java.util.List;

public interface RecommendationService {
    public long addRecommendation(RecommendationRequest recommendationRequest);
    public void updateRecommendations();
    public void deleteRecommendation();
    public RecommendationResponse findRecommendationById(long id);
    public List<RecommendationResponse> getRecommendationsByProductId(long productId);
}
