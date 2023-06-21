package com.example.designpattern.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/order")
@Tag(name = "[주문 시스템 API 명세서입니다.", description = "[주문 시스템 API 명세 확인 및 테스트 가능]")
@RestController
public class OrderController {

    /**
     * 1. 주문 생성 POST /order
     * 2. 주문 삭제 DELETE /order
     * 3. 주문 조회 GET / order
     * 4. 주문 수정 PUT / order
     */
}
