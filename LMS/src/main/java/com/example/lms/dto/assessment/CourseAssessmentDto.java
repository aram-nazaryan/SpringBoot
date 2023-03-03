package com.example.lms.dto.assessment;

import lombok.Data;

import java.util.List;

@Data
public class CourseAssessmentDto {
    private String name;
    private Long id;
    List<UserAssessmentDto> userDetails;
}
