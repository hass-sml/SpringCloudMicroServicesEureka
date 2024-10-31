package dev.kenmasml.productservice.dto.responses;

import lombok.*;

import java.util.List;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductCompositeResponse {

    private ProductResponse productResponse;
    private List<RecommendationResponse> recommendationResponse;
    private List<ReviewResponse> reviewResponse;
}