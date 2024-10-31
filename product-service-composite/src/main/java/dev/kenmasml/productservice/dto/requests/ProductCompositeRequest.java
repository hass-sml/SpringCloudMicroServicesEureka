package dev.kenmasml.productservice.dto.requests;

import dev.kenmasml.productservice.dto.responses.ProductResponse;
import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductCompositeRequest {

    private ProductResponse productResponse;
    private RecommendationResponse recommendationResponse;
    private ReviewResponse reviewResponse;
}

