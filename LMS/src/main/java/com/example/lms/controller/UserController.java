package com.example.lms.controller;

import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.UserDetailsDto;
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

    @GetMapping("/{role}")
    public ResponseEntity<List<UserRegisterResponseDto>> getUsersByRole(@PathVariable("role") String role) {
        log.info("Get all - {}", role);
        List<UserRegisterResponseDto> users = userService.getUsersByRole(role);
        return ResponseEntity.status(users.get(0).getStatus()).body(users);
    }

    @GetMapping("/details/{uuid}")
    public ResponseEntity<UserDetailsDto> getSingleUser (@PathVariable("uuid") String uuid) {
        log.info("Get details - {}", uuid);
        UserDetailsDto user = userService.get(uuid);
        return ResponseEntity.status(user.getStatus()).body(user);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<UpdateResponseMessageDto> delete(@PathVariable("uuid") String uuid) {
        log.info("Delete user with uuid - {}", uuid);
        UpdateResponseMessageDto delete = userService.delete(uuid);
        return ResponseEntity.status(delete.getStatus()).body(delete);
    }
}
