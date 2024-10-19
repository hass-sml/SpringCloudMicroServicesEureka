package dev.kenmasml.productservice.domain;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor @AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    @Column(name = "product_name")
    private String name;
    @Column(name = "weight")
    private double weight;
    private long recommendationId;
    private long reviewId;
}
