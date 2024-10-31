package dev.kenmasml.productservice.dto.responses;


import lombok.*;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String path;
}
