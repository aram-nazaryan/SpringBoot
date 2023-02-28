package com.example.lms.dto.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorType {
    INVALID_BODY("missing_body_parameters", HttpStatus.BAD_REQUEST),
    ALREADY_REGISTERED("email_or_phone_already_registered", HttpStatus.IM_USED),
    COURSE_NOT_FOUND("course_not_found", HttpStatus.NOT_FOUND),
    NOT_EXISTS("course_does_not_exists", HttpStatus.NOT_ACCEPTABLE),
    USER_NOT_EXISTS("user_does_not_exists", HttpStatus.NOT_ACCEPTABLE);

    private final String id;
    private final HttpStatus httpStatus;

    ErrorType (String id, HttpStatus httpStatus) {
        this.id = id;
        this.httpStatus = httpStatus;
    }

    public ErrorDto errorDto() {
        return new ErrorDto(getId(), name(), getHttpStatus());
    }
}
