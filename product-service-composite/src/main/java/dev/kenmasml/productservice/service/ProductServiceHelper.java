package dev.kenmasml.productservice.service;

import dev.kenmasml.productservice.clients.OpenFeignProduct;
import dev.kenmasml.productservice.clients.OpenFeignRecommendation;
import dev.kenmasml.productservice.clients.OpenFeignReview;
import dev.kenmasml.productservice.dto.responses.ProductResponse;
import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceHelper {

    private final OpenFeignProduct openFeignProduct;
    private final OpenFeignRecommendation openFeignRecommendation;
    private final OpenFeignReview openFeignReview;
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceHelper.class);

    @Autowired
    public ProductServiceHelper(OpenFeignProduct openFeignProduct,
                                OpenFeignRecommendation openFeignRecommendation,
                                OpenFeignReview openFeignReview) {
        this.openFeignProduct = openFeignProduct;
        this.openFeignRecommendation = openFeignRecommendation;
        this.openFeignReview = openFeignReview;
    }

    @CircuitBreaker(name = "productCompositeService", fallbackMethod = "getDummyProduct")
    public ProductResponse getProductById(long id) {
        logger.info("Calling getProductById with ID: {}", id);
        return openFeignProduct.getProductById(id);
    }

    public ProductResponse getDummyProduct(long id, Throwable throwable) {
        logger.error("Error fetching product with ID {}: {}", id, throwable.getMessage());
        return new ProductResponse(id, "Default Product", 0);
    }

    @CircuitBreaker(name = "productCompositeService", fallbackMethod = "getDummyRecommendations")
    public List<RecommendationResponse> getRecommendationsByProductId(long id) {
        logger.info("Calling getRecommendationsByProductId with ID: {}", id);
        return openFeignRecommendation.getRecommendationsByProductId(id);
    }

    public List<RecommendationResponse> getDummyRecommendations(long id, Throwable throwable) {
        logger.error("Error fetching recommendations for Product ID {}: {}", id, throwable.getMessage());
        return List.of(new RecommendationResponse(id, "Default Author", 0, "Default Content"));
    }

    @CircuitBreaker(name = "productCompositeService", fallbackMethod = "getDummyReviews")
    public List<ReviewResponse> getReviewsByProductId(long id) {
        logger.info("Calling getReviewsByProductId with ID: {}", id);
        return openFeignReview.getReviewsByProductId(id);
    }

    public List<ReviewResponse> getDummyReviews(long id, Throwable throwable) {
        logger.error("Error fetching reviews for Product ID {}: {}", id, throwable.getMessage());
        return List.of(new ReviewResponse(id, "Default Reviewer", "Default Subject", "No Review Content"));
    }
}
