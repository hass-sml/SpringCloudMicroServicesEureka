package dev.kenmasml.productservice.dto.requests;

import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductRequest {

    private long productId;
    private String name;
    private double weight;
}

