package com.example.lms.dto.assessment;

import lombok.Data;

@Data
public class AssessmentUpdateRequestDto {
    private Long userId;
    private Long courseId;
    private Long assessmentId;
    private String comment;
    private Double grade;
    private Boolean passedStatus;
}
