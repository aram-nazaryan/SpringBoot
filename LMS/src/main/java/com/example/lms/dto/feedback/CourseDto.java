package com.example.lms.dto.feedback;

import lombok.Data;

import java.util.List;

@Data
public class CourseDto {
    private String name;
    private List<SessionFeedbackDto> sessions;
}
