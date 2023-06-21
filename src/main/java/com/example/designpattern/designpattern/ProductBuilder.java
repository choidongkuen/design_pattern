package com.example.designpattern.designpattern;

import com.example.designpattern.domain.entity.Product;

public class ProductBuilder {
    private String name = null;

    private Integer price = null;

    private Integer salePrice = null;

    private Integer stock = null;

    public ProductBuilder(String name, Integer price, Integer salePrice, Integer stock) {
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
    }


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

    public Product build() {
        return new Product(this.name, this.price, this.salePrice, this.stock);
    }
}
