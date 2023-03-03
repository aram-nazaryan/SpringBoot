package com.example.lms.service;

import com.example.lms.dto.*;
import com.example.lms.dto.feedback.FeedbackDto;
import com.example.lms.dto.feedback.FeedbackRequestDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserRegisterResponseDto register(UserRegisterDto userRegisterDto);

    List<UserRegisterResponseDto> getUsers(Pageable pageable);

    UpdateResponseMessageDto delete(String uuid);

    List<UserRegisterResponseDto> getUsersByRole(String role);

    UserDetailsDto get(String uuid);

    FeedbackDto getFeedback(FeedbackRequestDto feedbackRequestDto);
}
