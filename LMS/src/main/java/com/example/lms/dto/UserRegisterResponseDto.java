package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import lombok.Builder;
import lombok.Data;

@Data
public class UserRegisterResponseDto extends AbstractResponseDto {
    private String uuid;
    private String firstName;
    private String lastName;

    public UserRegisterResponseDto() {
    }

    public UserRegisterResponseDto(ErrorDto errorDto) {
        super(errorDto);
    }
}
