package dev.kenmasml.productservice.domain;


import lombok.*;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class ProductComposite {
    private long productId;
    private long recommendationId;
    private long reviewId;
}
