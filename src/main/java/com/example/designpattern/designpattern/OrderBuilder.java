package com.example.designpattern.designpattern;

import com.example.designpattern.domain.entity.Orders;
import com.example.designpattern.domain.entity.Products;
import com.example.designpattern.domain.entity.User;

public class OrderBuilder {

    private Boolean orderStatus;

    private String receiver;

    private String sender;

    private String telephone;

    private String orderComment;

    private Products products;

    private User user;

    public OrderBuilder setOrderStatus(boolean orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderBuilder setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public OrderBuilder setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public OrderBuilder setTelephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public OrderBuilder setOrderComment(String comment) {
        this.orderComment = comment;
        return this;
    }

    public OrderBuilder setProduct(Products products) {
        this.products = products;
        return this;
    }

    public OrderBuilder setUser(User user) {
        this.user = user;
        return this;
    }

    public Orders build() {
        return new Orders(this.orderStatus, this.receiver, this.sender,
                this.telephone, this.orderComment, this.products, this.user);
    }
}
