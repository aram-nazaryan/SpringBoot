package com.example.lms.dto.assessment;

import lombok.Data;

import java.util.List;

@Data
public class AssessmentResponseDto {
    private Long id;
    private Integer number;

    List<UserAssessmentDto> assessments;
}
