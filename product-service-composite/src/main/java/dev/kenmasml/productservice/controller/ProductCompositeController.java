package dev.kenmasml.productservice.controller;


import dev.kenmasml.productservice.dto.responses.ProductCompositeResponse;
import dev.kenmasml.productservice.service.ProductCompositeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/composer")
public class ProductCompositeController {
    private ProductCompositeService productCompositeService;


    @GetMapping("/{id}")
    public ResponseEntity<ProductCompositeResponse> getProductCompositeById(@PathVariable("id") long id) {
        ProductCompositeResponse productCompositeResponse = productCompositeService.getProductCompositeById(id);
        return ResponseEntity.ok().body(productCompositeResponse);
    }

}
