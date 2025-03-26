package com.microservice.OrderService.external.client;

import com.microservice.OrderService.config.FeignConfig;
import com.microservice.OrderService.external.request.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE", configuration = FeignConfig.class)
public interface PaymentService {
    @PostMapping("/payment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);
}
