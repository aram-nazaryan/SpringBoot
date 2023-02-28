package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import lombok.Data;

@Data
public class UpdateResponseMessageDto extends AbstractResponseDto {
    private String message;

    public UpdateResponseMessageDto(ErrorDto errorDto) {
        super(errorDto);
    }

    public UpdateResponseMessageDto() {
    }

    public UpdateResponseMessageDto(String message) {
        this.message = message;
    }
}
