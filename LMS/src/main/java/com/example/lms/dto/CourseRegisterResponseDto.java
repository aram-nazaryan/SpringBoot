package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import lombok.*;

@Data
public class CourseRegisterResponseDto extends AbstractResponseDto{
    private String uuid;
    private String name;


    public CourseRegisterResponseDto() {};
    public CourseRegisterResponseDto(ErrorDto errorDto) { super(errorDto);}
}
