package com.microservice.PaymentService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "TRANSACTION_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Order_Id")
    private long orderId;

    @Column(name = "Mode")
    private String paymentMode;

    @Column(name = "Reference_Number")
    private String referenceNumber;

    @Column(name = "Payment_Date")
    private Instant paymentDate;

    @Column(name = "Status")
    private String paymentStatus;

    @Column(name = "Amount")
    private long amount;
}
