package com.example.lms.dto.feedback;

import com.example.lms.dto.feedback.UserAssessmentFeedbackDto;
import lombok.Data;

import java.util.List;

@Data
public class AssessmentDto {
    private Integer number;
    private List<UserAssessmentFeedbackDto> assessmentFeedbackDtos;
}
