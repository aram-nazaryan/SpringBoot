package com.example.lms.dto.feedback;

import com.example.lms.dto.AbstractResponseDto;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class FeedbackDto extends AbstractResponseDto {
    private String uuid;
    private String firstName;
    private String lastName;
    private Double attendancePercentage = 10.0;

    private Set<CourseDto> courses;
    private List<AssessmentDto> assessments;
}
