package com.microservice.CloudGateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/orderServiceFallBack")
    public String orderServiceFallback(){
        return "OrderService is down";
    }

    @GetMapping("/productServiceFallBack")
    public String productServiceFallback(){
        return "ProductService is down";
    }

    @GetMapping("/paymentServiceFallBack")
    public String paymentServiceFallback(){
        return "PaymentService is down";
    }

}
