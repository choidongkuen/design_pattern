package com.example.designpattern.domain.repository;

import com.example.designpattern.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
