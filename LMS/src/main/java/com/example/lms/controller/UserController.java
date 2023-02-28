package com.example.lms.controller;

import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import com.example.lms.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponseDto> register(@RequestBody UserRegisterDto registerDto) {
        log.info("User register with body - {}", registerDto);
        UserRegisterResponseDto register = userService.register(registerDto);
        return ResponseEntity.status(register.getStatus()).body(register);
    }

    @GetMapping
    public ResponseEntity<List<UserRegisterResponseDto>> getUsers(@PageableDefault(size = 5)Pageable pageable) {
        log.info("Get users - {}", pageable);
        List<UserRegisterResponseDto> users = userService.getUsers(pageable);
        return ResponseEntity.ok(users);
    }
}
