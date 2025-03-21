package com.microservice.OrderService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Order_Details")
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Product_Id")
    private long productId;

    @Column(name = "Quantity")
    private long quantity;
    @Column(name = "Order_Date")
    private Instant orderDate;
    @Column(name = "Status")
    private String orderStatus;
    @Column(name = "Total_Amount")
    private long amount;
}
