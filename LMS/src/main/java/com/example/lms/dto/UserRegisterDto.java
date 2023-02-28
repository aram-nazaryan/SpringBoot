package com.example.lms.dto;

import com.example.lms.domain.enums.Role;
import lombok.Builder;
import lombok.Data;

@Data
public class UserRegisterDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
}
