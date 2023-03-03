package com.example.lms.dto.course;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CourseRegisterDto {
    private String name;

    private Integer numberOfSessions;

    private LocalDate startDate;

    private LocalDate endDate;

}
