package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import lombok.Data;

@Data
public class CourseUpdateResponseDto extends AbstractResponseDto {
    private final String message = "Course updated";

    public CourseUpdateResponseDto(ErrorDto errorDto) {
        super(errorDto);
    }

    public CourseUpdateResponseDto() {
    }
}
