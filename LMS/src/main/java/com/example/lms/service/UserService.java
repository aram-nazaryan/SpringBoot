package com.example.lms.service;

import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterDto userRegisterDto);

    List<UserRegisterResponseDto> getUsers(Pageable pageable);
}
