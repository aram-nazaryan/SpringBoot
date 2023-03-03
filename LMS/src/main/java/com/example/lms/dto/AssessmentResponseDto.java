package com.example.lms.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssessmentResponseDto {
    private Long id;
    private Integer number;

    List<UserAssessmentDto> assessments;
}
