package com.example.lms.dto.course;

import lombok.Data;

import java.util.List;

@Data
public class CourseParticipantsDto {
    private String uuid;
    private List<String> userUuids;
}
