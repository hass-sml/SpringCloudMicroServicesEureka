package dev.kenmasml.productservice.service;


import dev.kenmasml.productservice.clients.OpenFeignRecommendation;
import dev.kenmasml.productservice.clients.OpenFeignReview;
import dev.kenmasml.productservice.dao.ProductDao;
import dev.kenmasml.productservice.domain.Product;
import dev.kenmasml.productservice.dto.requests.ProductRequest;
import dev.kenmasml.productservice.dto.responses.ProductResponse;
import dev.kenmasml.productservice.dto.responses.RecommendationResponse;
import dev.kenmasml.productservice.dto.responses.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {


    private final OpenFeignRecommendation openFeignRecommendation;
    private final OpenFeignReview openFeignReview;
    private final ProductDao productDao;


    @Autowired
    public ProductServiceImpl(OpenFeignReview openFeignReview,
                              OpenFeignRecommendation openFeignRecommendation,
                              ProductDao productDao) {
        this.openFeignReview = openFeignReview;
        this.openFeignRecommendation = openFeignRecommendation;
        this.productDao = productDao;
    }

    @Override
    public long addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());
        product.setProductId(productRequest.getProductId());
        product.setReviewId(productRequest.getReviewResponse().getReviewId());
        product.setRecommendationId(productRequest.getRecommendationResponse().getRecommendationId());
        productDao.save(product);
        return product.getProductId();
    }
    @Override
    public ProductResponse getProducts(long productId) {
        ProductResponse productResponse = new ProductResponse();
        Product product = productDao.findById(productId).orElseThrow(() -> new RuntimeException("Product "+productId+" not found"));
        productResponse.setProductId(product.getProductId());
        productResponse.setName(product.getName());
        productResponse.setWeight(product.getWeight());
        productResponse.setReviewResponse(getReviewById(product.getReviewId()));
        productResponse.setRecommendationResponse(getRecommendationById(product.getRecommendationId()));
        return productResponse;
    }
    public ReviewResponse getReviewById(long reviewId) {
        return openFeignReview.getReviewById(reviewId);
    }
    public RecommendationResponse getRecommendationById(long recommendationId) {
        return openFeignRecommendation.getRecommendationById(recommendationId);
    }

//    @Override
//    public void updateProduct() {
//        System.out.println("Product updated");
//    }
//
//    @Override
//    public void deleteProduct() {
//        System.out.println("Product deleted");
//    }
}
