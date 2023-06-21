package com.example.designpattern.service;

import com.example.designpattern.designpattern.ProductBuilder;
import com.example.designpattern.domain.entity.Products;
import com.example.designpattern.domain.repository.ProductRepository;
import com.example.designpattern.dto.product.CreateProductRequestDto;
import com.example.designpattern.dto.product.UpdateProductRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long createProduct(CreateProductRequestDto request) {

        Products product = new ProductBuilder().setName(request.getName())
                                               .setPrice(request.getPrice())
                                               .setSalePrice(request.getSalePrice())
                                               .setStock(request.getStock())
                                               .setIsSold(true)
                                               .setCreatedAt(LocalDateTime.now())
                                               .build();


        return this.productRepository.save(product).getId();
    }

    @Transactional
    public void updateProduct(Long productId, UpdateProductRequestDto request) {

        Products product = this.productRepository.findById(productId)
                                                 .orElseThrow(() -> new RuntimeException("일치하는 상품 정보가 존재하지 않습니다."));

        Products newProduct = new ProductBuilder()
                .setName(request.getName())
                .setPrice(request.getPrice())
                .setSalePrice(request.getSalePrice())
                .setStock(product.getStock())
                .build();

        this.productRepository.delete(product);
        this.productRepository.save(newProduct);
    }
}
