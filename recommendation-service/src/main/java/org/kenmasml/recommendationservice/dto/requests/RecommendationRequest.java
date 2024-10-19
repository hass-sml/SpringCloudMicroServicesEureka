package org.kenmasml.recommendationservice.dto.requests;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class RecommendationRequest {
    private Long recommendationId;
    private String author;
    private int rate;
    private String content;
}

