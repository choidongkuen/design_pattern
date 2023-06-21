package com.example.designpattern.controller;

import com.example.designpattern.dto.product.CreateProductRequestDto;
import com.example.designpattern.dto.product.UpdateProductRequestDto;
import com.example.designpattern.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<Long> createProduct(
            @Valid @RequestBody CreateProductRequestDto request
    ) {
        return new ResponseEntity<>(this.productService.createProduct(request), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(
            @PathVariable(name = "productId") Long productId,
            @Valid @RequestBody UpdateProductRequestDto request
    ) {
        this.productService.updateProduct(productId, request);
        return ResponseEntity.ok().build();
    }
}
