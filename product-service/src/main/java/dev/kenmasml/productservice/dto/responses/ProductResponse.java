package dev.kenmasml.productservice.dto.responses;

import lombok.*;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ProductResponse {
    private long productId;
    private String name;
    private double weight;

}
