package org.kenmasml.recommendationservice.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "recommendations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recommendationId;
    private Long productId;
    @Column(name = "author")
    private String author;
    @Column(name = "rate")
    private int rate;
    @Column(name = "content")
    private String content;
}