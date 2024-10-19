package org.chaimaa.reviewservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
//    @Column(name = "productId")
//    private Long productId;
    @Column(name = "author")
    private String author;
    @Column(name = "subject")
    private String subject;
    @Column(name = "content")
    private String content;
}