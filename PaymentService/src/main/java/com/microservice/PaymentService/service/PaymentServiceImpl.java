package com.microservice.PaymentService.service;

import com.microservice.PaymentService.entity.TransactionDetails;
import com.microservice.PaymentService.model.PaymentMode;
import com.microservice.PaymentService.model.PaymentRequest;
import com.microservice.PaymentService.model.PaymentResponse;
import com.microservice.PaymentService.repository.TransactionDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private TransactionDetailsRepository transactionDetailsRepository;

    @Override
    public Long doPayment(PaymentRequest paymentRequest) {

        TransactionDetails transactionDetails =
                TransactionDetails.builder()
                        .paymentDate(Instant.now())
                        .paymentMode(paymentRequest.getPaymentMode().name())
                        .paymentStatus("SUCCESS")
                        .orderId(paymentRequest.getOrderId())
                        .referenceNumber(paymentRequest.getReferenceNumber())
                        .amount(paymentRequest.getAmount())
                        .build();

        transactionDetailsRepository.save(transactionDetails);

        return transactionDetails.getId();
    }

    @Override
    public PaymentResponse getPaymentDetailsByOrderId(String orderId) {

        TransactionDetails transactionDetails
                = transactionDetailsRepository.findByOrderId(Long.valueOf(orderId));

        PaymentResponse paymentResponse
                = PaymentResponse.builder()
                .paymentId(transactionDetails.getId())
                .paymentDate(transactionDetails.getPaymentDate())
                .paymentMode(PaymentMode.valueOf(transactionDetails.getPaymentMode()))
                .orderId(transactionDetails.getOrderId())
                .paymentStatus(transactionDetails.getPaymentStatus())
                .amount(transactionDetails.getAmount())
                .build();

        return paymentResponse;
    }
}
