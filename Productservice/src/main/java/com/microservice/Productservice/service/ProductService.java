package com.microservice.Productservice.service;

import com.microservice.Productservice.model.ProductRequest;
import com.microservice.Productservice.model.ProductResponse;

public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);
}
