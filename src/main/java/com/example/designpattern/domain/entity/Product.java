package com.example.designpattern.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "sale_price", nullable = false)
    private Integer salePrice;

    @Column(name = "stock")
    @ColumnDefault("0")
    private Integer stock;

    @Column(name = "is_sold")
    private Boolean isSold;

    public Product(String name, Integer price, Integer salePrice, Integer stock) {
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
    }
}
