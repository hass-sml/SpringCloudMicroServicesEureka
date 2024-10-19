package org.kenmasml.recommendationservice.service;

import org.kenmasml.recommendationservice.dto.requests.RecommendationRequest;
import org.kenmasml.recommendationservice.dto.responses.RecommendationResponse;

public interface RecommendationService {
    public long addRecommendation(RecommendationRequest recommendationRequest);
    public void updateRecommendations();
    public void deleteRecommendation();
    public RecommendationResponse findRecommendationById(long id);
}
