package dev.kenmasml.productservice.service;


import dev.kenmasml.productservice.clients.OpenFeignProduct;
import dev.kenmasml.productservice.clients.OpenFeignRecommendation;
import dev.kenmasml.productservice.clients.OpenFeignReview;
import dev.kenmasml.productservice.dto.responses.ProductCompositeResponse;
import dev.kenmasml.productservice.dto.responses.ProductResponse;
import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCompositeService{


    private final OpenFeignRecommendation openFeignRecommendation;
    private final OpenFeignReview openFeignReview;
    private final OpenFeignProduct openFeignProduct;


    @Autowired
    public ProductCompositeService(OpenFeignRecommendation openFeignRecommendation, OpenFeignReview openFeignReview, OpenFeignProduct openFeignProduct) {
        this.openFeignRecommendation = openFeignRecommendation;
        this.openFeignReview = openFeignReview;
        this.openFeignProduct = openFeignProduct;
    }



    public ProductCompositeResponse getProductCompositeById(long id) {
        ProductCompositeResponse productCompositeResponse = new ProductCompositeResponse();

        // Fetch product details
        ProductResponse productResponse = openFeignProduct.getProductById(id);
        productCompositeResponse.setProductResponse(productResponse);

        // Fetch associated recommendations and reviews
        List<RecommendationResponse> recommendations = openFeignRecommendation.getRecommendationsByProductId(id);
        productCompositeResponse.setRecommendationResponse(recommendations);

        // Fetch associated recommendations and reviews
        List<ReviewResponse> reviews = openFeignReview.getReviewsByProductId(id);
        productCompositeResponse.setReviewResponse(reviews);

        return productCompositeResponse;
    }

}
