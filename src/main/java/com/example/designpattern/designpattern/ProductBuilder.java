package com.example.designpattern.designpattern;

import com.example.designpattern.domain.entity.Products;

import java.time.LocalDateTime;

public class ProductBuilder {
    private String name = null;

    private Integer price = null;

    private Integer salePrice = null;

    private Integer stock = null;

    private Boolean isSold = null;

    private LocalDateTime createdAt = null;


    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public ProductBuilder setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public ProductBuilder setStock(Integer stock) {
        this.stock = stock;
        return this;
    }

    public ProductBuilder setIsSold(Boolean isSold) {
        this.isSold = true;
        return this;
    }

    public ProductBuilder setCreatedAt(LocalDateTime time) {
        this.createdAt = time;
        return this;
    }

    public Products build() {
        return new Products(this.name, this.price,
                this.salePrice, this.stock, this.isSold, this.createdAt);
    }
}
