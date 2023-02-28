package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import lombok.Data;

@Data
public class HomeworkResponseDto extends AbstractResponseDto {
    private String name;
    private Integer number;

    public HomeworkResponseDto() {
    }

    public HomeworkResponseDto(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public HomeworkResponseDto(ErrorDto errorDto) {
        super(errorDto);
    }
}
