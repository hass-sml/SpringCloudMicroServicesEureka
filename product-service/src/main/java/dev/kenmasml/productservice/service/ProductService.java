package dev.kenmasml.productservice.service;

import dev.kenmasml.productservice.dto.requests.ProductRequest;
import dev.kenmasml.productservice.dto.responses.ProductResponse;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);
    public ProductResponse getProducts(long productId);
}
