package com.example.designpattern.designpattern;

import com.example.designpattern.domain.entity.Orders;
import com.example.designpattern.domain.entity.Products;
import com.example.designpattern.domain.entity.User;

public class OrderBuilder {

    private String orderStatus;

    private String addressee;

    private String address;

    private String telephone;

    private String orderComment;

    private Products products;

    private User user;

    public OrderBuilder setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public OrderBuilder setAddressee(String addressee) {
        this.addressee = addressee;
        return this;
    }

    public OrderBuilder setAddress(String address) {
        this.address = address;
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
        return new Orders(this.orderStatus, this.addressee, this.address,
                this.telephone, this.orderComment, this.products, this.user);
    }
}
