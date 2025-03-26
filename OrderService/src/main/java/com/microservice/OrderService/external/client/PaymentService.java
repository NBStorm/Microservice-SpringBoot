package com.microservice.OrderService.external.client;

import com.microservice.OrderService.config.FeignConfig;
import com.microservice.OrderService.exception.CustomException;
import com.microservice.OrderService.external.request.PaymentRequest;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CircuitBreaker(name = "external", fallbackMethod = "fallback")
@FeignClient(name = "PAYMENT-SERVICE", configuration = FeignConfig.class)
public interface PaymentService {
    @PostMapping("/payment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);

    default void fallback(Exception e) {
        throw new CustomException("Payment Service is not available",
                "UNVAILABLE",
                500);
    }
}
