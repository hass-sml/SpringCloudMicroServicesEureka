package dev.kenmasml.productservice.service;

import dev.kenmasml.productservice.dto.requests.ProductRequest;
import dev.kenmasml.productservice.dto.responses.ProductResponse;

import java.util.List;

public interface ProductService {
    public long addProduct(ProductRequest productRequest);
    public void updateProduct(ProductRequest productRequest, long productId);
    public ProductResponse getProductById(long productId);
    public List<ProductResponse> getAllProducts();
    public void deleteProduct(long productId);
}
