package com.example.lms.service;

import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.UserDetailsDto;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterDto userRegisterDto);

    List<UserRegisterResponseDto> getUsers(Pageable pageable);

    UpdateResponseMessageDto delete(String uuid);

    List<UserRegisterResponseDto> getUsersByRole(String role);

    UserDetailsDto get(String uuid);
}
