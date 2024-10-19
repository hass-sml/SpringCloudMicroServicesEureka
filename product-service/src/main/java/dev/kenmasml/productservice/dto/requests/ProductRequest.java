package dev.kenmasml.productservice.dto.requests;

import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductRequest {

    private long productId;
    private String name;
    private double weight;
    private RecommendationResponse recommendationResponse;
    private ReviewResponse reviewResponse;
}

