package com.example.lms.dto.course;

import lombok.Data;

@Data
public class AttendanceDto {
    private Long sessionId;
    private Long userId;
    private String userName;
    private String userSurname;
    private Boolean attendedStatus;
}
