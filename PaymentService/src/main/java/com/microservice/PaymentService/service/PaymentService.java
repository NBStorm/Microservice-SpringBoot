package com.microservice.PaymentService.service;

import com.microservice.PaymentService.model.PaymentRequest;
import com.microservice.PaymentService.model.PaymentResponse;

public interface PaymentService {
    Long doPayment(PaymentRequest paymentRequest);

    PaymentResponse getPaymentDetailsByOrderId(String orderId);
}
