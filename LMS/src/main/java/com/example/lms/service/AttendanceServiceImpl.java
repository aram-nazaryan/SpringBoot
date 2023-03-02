package com.example.lms.service;

import com.example.lms.domain.Attendance;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.AttendanceDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;

    @Override
    public UpdateResponseMessageDto update (AttendanceDto attendanceDto) {
        Attendance attendance = attendanceRepository.findBySession_IdAndUser_Id(attendanceDto.getSessionId(), attendanceDto.getUserId());
        if (attendance == null) {
            ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
            return new UpdateResponseMessageDto(errorDto);
        }
        attendance.setAttendedStatus(attendanceDto.getAttendedStatus());
        attendanceRepository.save(attendance);
        return new UpdateResponseMessageDto(Message.ATTENDANCE_UPDATED.getMessage());
    }
}
