package com.example.designpattern.domain.repository;

import com.example.designpattern.domain.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
