package com.example.lms.dto.assessment;

import com.example.lms.dto.UserRegisterResponseDto;
import com.example.lms.dto.course.CourseRegisterResponseDto;
import lombok.Data;

@Data
public class UserAssessmentDto {
    private Long userId;
    private UserRegisterResponseDto user;
    private String comment;
    private Double grade;
    private Boolean passedStatus;
}
