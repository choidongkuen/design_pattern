package com.example.designpattern.service;

import com.example.designpattern.designpattern.OrderBuilder;
import com.example.designpattern.domain.entity.Orders;
import com.example.designpattern.domain.entity.Products;
import com.example.designpattern.domain.entity.User;
import com.example.designpattern.domain.repository.OrderRepository;
import com.example.designpattern.domain.repository.ProductRepository;
import com.example.designpattern.domain.repository.UserRepository;
import com.example.designpattern.dto.order.CreateOrderRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Long createOrder(CreateOrderRequestDto request) {

        User user = this.userRepository.findById(request.getUserId())
                                       .orElseThrow(() -> new RuntimeException("일치하는 회원 정보가 존재하지 않습니다."));

        Products product = this.productRepository.findById(request.getProductId())
                                                 .orElseThrow(() -> new RuntimeException("일치하는 상품 정보가 존재하지 않습니다."));

        Orders order = new OrderBuilder().setUser(user)
                                         .setProduct(product)
                                         .setOrderComment(request.getOrderComment())
                                         .setReceiver(request.getReceiver())
                                         .setSender(request.getSender())
                                         .setTelephone(request.getTelephone())
                                         .setOrderStatus(true)
                                         .build();

        order.setCreatedAt(LocalDateTime.now());

        return this.orderRepository.save(order).getId();
    }
}
