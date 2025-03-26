package com.microservice.OrderService.service;

import com.microservice.OrderService.entity.Order;
import com.microservice.OrderService.exception.CustomException;
import com.microservice.OrderService.external.client.PaymentService;
import com.microservice.OrderService.external.client.ProductService;
import com.microservice.OrderService.external.request.PaymentRequest;
import com.microservice.OrderService.external.response.PaymentResponse;
import com.microservice.OrderService.model.OrderRequest;
import com.microservice.OrderService.model.OrderResponse;
import com.microservice.OrderService.repository.OrderRepository;
import com.microservice.Productservice.model.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public long placeOrder(OrderRequest orderRequest) {

        productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());

        Order order
                = Order.builder()
                .amount(orderRequest.getTotalAmount())
                .orderStatus("CREATED")
                .productId(orderRequest.getProductId())
                .orderDate(Instant.now())
                .quantity(orderRequest.getQuantity())
                .build();

        order = orderRepository.save(order);

        PaymentRequest paymentRequest
                = PaymentRequest.builder()
                .orderId(order.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(orderRequest.getTotalAmount())
                .build();

        String orderStatus = null;
        try {
            paymentService.doPayment(paymentRequest);
            orderStatus = "PLACED";
        }catch (Exception e){
            e.printStackTrace();
            orderStatus = "ERROR";
        }

        order.setOrderStatus(orderStatus);
        orderRepository.save(order);

        return order.getId();
    }

    @Override
    public OrderResponse getOrderDetails(long orderId) {

        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new CustomException("Order not found for id:"+ orderId,"Not Found",404));

        ProductResponse productResponse
                = restTemplate.getForObject("http://PRODUCT-SERVICE/product/"+order.getProductId(), ProductResponse.class);

        PaymentResponse paymentRespons
                = restTemplate.getForObject("http://PAYMENT-SERVICE/payment/order/"+orderId, PaymentResponse.class);

        OrderResponse.ProductDetails productDetails
                = OrderResponse.ProductDetails.builder()
                .productName(productResponse.getProductName())
                .productId(productResponse.getProductId())
                .build();

        OrderResponse.PaymentDetails paymentDetails
                = OrderResponse.PaymentDetails.builder()
                .paymentId(paymentRespons.getPaymentId())
                .paymentMode(paymentRespons.getPaymentMode())
                .paymentStatus(paymentRespons.getPaymentStatus())
                .paymentDate(paymentRespons.getPaymentDate())
                .build();

        OrderResponse orderResponse = OrderResponse.builder()
                .orderId(order.getId())
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .orderDate(order.getOrderDate())
                .productDetails(productDetails)
                .paymentDetails(paymentDetails)
                .build();

        return orderResponse;
    }
}
