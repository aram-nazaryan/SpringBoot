package com.example.lms.dto;

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
