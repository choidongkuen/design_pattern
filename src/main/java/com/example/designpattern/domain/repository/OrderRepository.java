package com.example.designpattern.domain.repository;

import com.example.designpattern.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
