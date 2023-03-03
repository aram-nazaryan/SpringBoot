package com.example.lms.dto.assessment;

import com.example.lms.dto.UserRegisterResponseDto;
import com.example.lms.dto.course.CourseRegisterResponseDto;
import lombok.Data;

@Data
public class UserAssessmentDto {
    private Long userId;
    private UserRegisterResponseDto user;
    private Long courseId;
    private CourseRegisterResponseDto course;
    private Long assessmentId;
    private String comment;
    private Double grade;
    private Boolean passedStatus;
}
