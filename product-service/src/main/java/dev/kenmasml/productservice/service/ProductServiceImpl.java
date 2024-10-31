package dev.kenmasml.productservice.service;


import dev.kenmasml.productservice.dao.ProductDao;
import dev.kenmasml.productservice.domain.Product;
import dev.kenmasml.productservice.dto.requests.ProductRequest;
import dev.kenmasml.productservice.dto.responses.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductDao productDao;


    @Override
    public long addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setWeight(productRequest.getWeight());
        product.setProductId(productRequest.getProductId());
        productDao.save(product);
        return product.getProductId();
    }
    @Override
    public ProductResponse getProductById(long productId) {
        ProductResponse productResponse = new ProductResponse();
        Product product = productDao.findById(productId).orElseThrow(() -> new RuntimeException("Product "+productId+" not found"));
        productResponse.setProductId(product.getProductId());
        productResponse.setName(product.getName());
        productResponse.setWeight(product.getWeight());
        return productResponse;
    }
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productDao.findAll();
        List<ProductResponse> productList = new ArrayList<ProductResponse>();
        for(Product product : products) {
            ProductResponse productResponse = new ProductResponse();
            productResponse.setProductId(product.getProductId());
            productResponse.setName(product.getName());
            productResponse.setWeight(product.getWeight());
            productList.add(productResponse);
        }
        return productList;
    }


    @Override
    public void updateProduct(ProductRequest productRequest, long productId) {
        Optional<Product> product = productDao.findById(productId);
        if (product.isPresent()) {
            Product prod = product.get();
            prod.setProductId(productRequest.getProductId());
            prod.setName(productRequest.getName());
            prod.setWeight(productRequest.getWeight());
            productDao.save(prod);
        }
    }

    @Override
    public void deleteProduct(long productId) {
        Optional<Product> product = productDao.findById(productId);
        product.ifPresent(productDao::delete);
    }
}
