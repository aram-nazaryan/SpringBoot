package com.example.lms.dto.feedback;

import lombok.Data;

@Data
public class SessionFeedbackDto {
    private Integer number;
    private Double grade;
    private String comment;
    private Boolean passedStatus;
}
