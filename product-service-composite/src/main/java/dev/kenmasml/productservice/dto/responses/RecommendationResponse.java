package dev.kenmasml.productservice.dto.responses;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor @Getter @Setter
public class RecommendationResponse {
    private Long recommendationId;
    private String author;
    private int rate;
    private String content;
}