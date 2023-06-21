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
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telephone", unique = true)
    private String telephone;

    @Column(name = "gender")
    private String gender;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_banned")
    private boolean isBanned; // 정지 여부

    public User(String name, String password, String telephone, String gender) {
        this.name = name;
        this.password = password;
        this.telephone = telephone;
        this.gender = gender;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
