package com.microservice.Productservice.service;

import com.microservice.Productservice.entity.Product;
import com.microservice.Productservice.exception.ProductServiceCustomException;
import com.microservice.Productservice.model.ProductRequest;
import com.microservice.Productservice.model.ProductResponse;
import com.microservice.Productservice.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.springframework.beans.BeanUtils.*;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public long addProduct(ProductRequest productRequest) {
        Product product
                = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);
        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ProductServiceCustomException("Product not found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse = new ProductResponse();
        copyProperties(product, productResponse);
        return productResponse;
    }
}
