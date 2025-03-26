package com.microservice.OrderService.service;

import com.microservice.OrderService.model.OrderRequest;
import com.microservice.OrderService.model.OrderResponse;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);

    OrderResponse getOrderDetails(long orderId);
}
