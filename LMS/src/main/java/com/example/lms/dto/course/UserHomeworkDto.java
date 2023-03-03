package com.example.lms.dto.course;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class UserHomeworkDto {
    private String comment;
    private Double grade;
    private Boolean passedStatus;
    private Long homeworkId;
    private Long userId;
    private String userName;
    private String userSurname;
}
