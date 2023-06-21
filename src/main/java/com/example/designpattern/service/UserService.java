package com.example.designpattern.service;

import com.example.designpattern.domain.repository.UserRepository;
import com.example.designpattern.dto.user.CreateUserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long createUser(CreateUserRequestDto request) {
        return null;
    }
}
