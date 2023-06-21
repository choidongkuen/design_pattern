package com.example.designpattern.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Products {

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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_sold")
    private Boolean isSold;

    public Products(String name, Integer price, Integer salePrice,
                    Integer stock, Boolean isSold, LocalDateTime time) {
        this.name = name;
        this.price = price;
        this.salePrice = salePrice;
        this.stock = stock;
        this.isSold = isSold;
        this.createdAt = time;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
