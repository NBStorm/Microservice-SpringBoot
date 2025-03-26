package com.microservice.OrderService.external.client;

import com.microservice.OrderService.config.FeignConfig;
import com.microservice.OrderService.exception.CustomException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PRODUCT-SERVICE", configuration = FeignConfig.class)
public interface ProductService {
    @PutMapping("/product/reduceQuantity/{id}")
    ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId,
            @RequestParam long quantity
    );

    default void fallback(Exception e) {
        throw new CustomException("Product Service is not available",
                "UNVAILABLE",
                500);
    }
}

