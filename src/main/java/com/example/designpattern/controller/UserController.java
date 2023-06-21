package com.example.designpattern.controller;

import com.example.designpattern.dto.user.CreateUserRequestDto;
import com.example.designpattern.dto.user.UpdateUserRequestDto;
import com.example.designpattern.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Long> createUser(
            @Valid @RequestBody CreateUserRequestDto request
    ) {
        return new ResponseEntity<>(this.userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(
            @PathVariable(name = "userId") Long userId,
            @Valid @RequestBody UpdateUserRequestDto request
    ) {
        this.userService.updateUser(userId, request);
        return ResponseEntity.ok().build();
    }
}
