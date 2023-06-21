package com.example.designpattern.controller;

import com.example.designpattern.dto.order.CreateOrderRequestDto;
import com.example.designpattern.service.OrderService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
@Tag(name = "[주문 시스템 API 명세서입니다.", description = "[주문 시스템 API 명세 확인 및 테스트 가능]")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping()
    public ResponseEntity<Long> createOrder(
            @Valid @RequestBody CreateOrderRequestDto request
    ) {
        return new ResponseEntity<>(this.orderService.createOrder(request), HttpStatus.CREATED);
    }

}
