package com.example.lms.controller;

import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.AttendanceDto;
import com.example.lms.dto.course.UserHomeworkDto;
import com.example.lms.service.AttendanceService;
import com.example.lms.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/update")
@Slf4j
@RequiredArgsConstructor
public class StudentUpdateController {

    private final AttendanceService attendanceService;
    private final HomeworkService homeworkService;

    @PostMapping("/attendance")
    public ResponseEntity<UpdateResponseMessageDto> updateAttendance(@RequestBody AttendanceDto attendanceDto) {
        log.info("Update user attendance with body - {}", attendanceDto);
        UpdateResponseMessageDto update = attendanceService.update(attendanceDto);
        return ResponseEntity.status(update.getStatus()).body(update);
    }

    @PostMapping("/homework")
    public ResponseEntity<UpdateResponseMessageDto> updateHomework(@RequestBody UserHomeworkDto homeworkDto) {
        log.info("Update user homework with body - {}", homeworkDto);
        UpdateResponseMessageDto homework = homeworkService.updateUserHomework(homeworkDto);
        return ResponseEntity.status(homework.getStatus()).body(homework);
    }
}
