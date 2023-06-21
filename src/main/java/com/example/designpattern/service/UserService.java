package com.example.designpattern.service;

import com.example.designpattern.designpattern.UserBuilder;
import com.example.designpattern.domain.entity.User;
import com.example.designpattern.domain.repository.UserRepository;
import com.example.designpattern.dto.user.CreateUserRequestDto;
import com.example.designpattern.dto.user.UpdateUserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public Long createUser(CreateUserRequestDto request) {

        User user = new UserBuilder().setName(request.getName())
                                     .setPassword(request.getPassword())
                                     .setGender(request.getGender())
                                     .setTelephone(request.getTelephone())
                                     .build();

        user.setCreatedAt(LocalDateTime.now());
        return this.userRepository.save(user).getId();
    }

    @Transactional
    public void updateUser(Long userId, UpdateUserRequestDto request) {

        User user = this.userRepository.findById(userId)
                                       .orElseThrow(() -> new RuntimeException("회원이 존재하지 않습니다."));

        User newUser = new UserBuilder().setName(request.getName())
                                        .setPassword(request.getPassword())
                                        .setGender(user.getGender())
                                        .setTelephone(user.getTelephone())
                                        .build();

        newUser.setCreatedAt(LocalDateTime.now());

        this.userRepository.delete(user); // 기존 회원 정보 삭제
        this.userRepository.save(newUser); // 새로운 회원 정보 저장
    }
}
