package com.example.lms.dto;

import com.example.lms.dto.error.ErrorDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractResponseDto {

    private ErrorDto errorDto;

//    @JsonIgnore
    private Integer status;

    public AbstractResponseDto(ErrorDto errorDto) {
        this.errorDto = errorDto;
        this.status = errorDto.getHttpStatus().value();
    }

    public AbstractResponseDto() {
        this.status = 200;
    }
}
