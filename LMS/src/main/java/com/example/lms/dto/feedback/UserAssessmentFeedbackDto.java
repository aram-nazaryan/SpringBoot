package com.example.lms.dto.feedback;

import lombok.Data;

@Data
public class UserAssessmentFeedbackDto {
    private String name;
    private String comment;
    private Double grade;
    private Boolean passedStatus;
}
