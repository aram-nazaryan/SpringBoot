package com.example.lms.dto;

import com.example.lms.domain.enums.Role;
import com.example.lms.dto.error.ErrorDto;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserDetailsDto extends AbstractResponseDto {


    private String uuid;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private Role role;

    private List<CourseRegisterResponseDto> courses;

    public UserDetailsDto() {
    }

    ;

    public UserDetailsDto(ErrorDto errorDto) {
        super(errorDto);
    }
}
