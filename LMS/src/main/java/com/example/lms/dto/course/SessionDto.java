package com.example.lms.dto.course;

import com.example.lms.domain.Attendance;
import lombok.Data;

import java.util.List;

@Data
public class SessionDto {

    private Long id;
    private Integer number;
    private Long courseId;
    private List<AttendanceDto> attendances;
    private HomeworkDto homework;

}
