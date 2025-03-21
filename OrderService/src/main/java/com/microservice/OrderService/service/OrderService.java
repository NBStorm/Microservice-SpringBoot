package com.microservice.OrderService.service;

import com.microservice.OrderService.model.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
