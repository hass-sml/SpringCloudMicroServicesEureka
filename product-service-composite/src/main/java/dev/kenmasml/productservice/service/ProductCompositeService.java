package dev.kenmasml.productservice.service;

import dev.kenmasml.productservice.dto.responses.ProductCompositeResponse;
import dev.kenmasml.productservice.dto.responses.ProductResponse;
import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCompositeService {

    private final ProductServiceHelper productServiceHelper;

    @Autowired
    public ProductCompositeService(ProductServiceHelper productServiceHelper) {
        this.productServiceHelper = productServiceHelper;
    }

    public ProductCompositeResponse getProductCompositeById(long id) {
        ProductCompositeResponse productCompositeResponse = new ProductCompositeResponse();

        // Fetch product details
        ProductResponse productResponse = productServiceHelper.getProductById(id);
        productCompositeResponse.setProductResponse(productResponse);

        // Fetch associated recommendations and reviews
        List<RecommendationResponse> recommendations = productServiceHelper.getRecommendationsByProductId(id);
        productCompositeResponse.setRecommendationResponse(recommendations);

        List<ReviewResponse> reviews = productServiceHelper.getReviewsByProductId(id);
        productCompositeResponse.setReviewResponse(reviews);

        return productCompositeResponse;
    }
}
