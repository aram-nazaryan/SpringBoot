package com.example.lms.dto.error;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {
    private String message;
    private String id;
    @JsonIgnore
    private HttpStatus httpStatus;
}
