package com.example.designpattern.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_status", nullable = false) // true -> 정상 저장
    private Boolean orderStatus;


    @Column(name = "receiver", nullable = false)
    private String receiver;

    @Column(name = "sender", nullable = false)
    private String sender;

    @Column(name = "telephone", nullable = false)
    private String telephone;

    @Column(name = "order_comment")
    private String orderComment;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    private Products products; // 주문당 상품 1개

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Orders(Boolean orderStatus, String receiver, String sender,
                  String telephone, String orderComment, Products products, User user) {
        this.orderStatus = orderStatus;
        this.receiver = receiver;
        this.sender = sender;
        this.telephone = telephone;
        this.orderComment = orderComment;
        this.products = products;
        this.user = user;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
