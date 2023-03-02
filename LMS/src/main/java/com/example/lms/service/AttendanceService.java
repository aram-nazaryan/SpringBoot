package com.example.lms.service;

import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.AttendanceDto;

public interface AttendanceService {
    UpdateResponseMessageDto update (AttendanceDto attendanceDto);
}
