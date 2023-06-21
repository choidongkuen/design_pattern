package com.example.designpattern.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Order extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_status", nullable = false)
    private String orderStatus;

    @Column(name = "addressee", nullable = false)
    private String addressee;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "order_comment")
    private String orderComment;

    @ManyToOne
    private Product product; // 주문당 상품 1개

    @OneToOne
    private User user;

    public Order(String orderStatus, String addressee, String address,
                 String telephone, String orderComment, Product product, User user) {
        this.orderStatus = orderStatus;
        this.addressee = addressee;
        this.address = address;
        this.telephone = telephone;
        this.orderComment = orderComment;
        this.product = product;
        this.user = user;
    }
}
