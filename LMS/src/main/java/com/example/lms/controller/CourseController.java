package com.example.lms.controller;

import com.example.lms.domain.Course;
import com.example.lms.dto.CourseParticipantsDto;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.CourseUpdateResponseDto;
import com.example.lms.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/course")
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/create")
    public ResponseEntity<CourseRegisterResponseDto> register(@RequestBody CourseRegisterDto registerDto) {
        log.info("Post register course with body - {}", registerDto);
        CourseRegisterResponseDto register = courseService.register(registerDto);
        log.info("Post register course response with body - {}", register);
        return ResponseEntity.status(register.getStatus()).body(register);
    }

    @PostMapping("/register")
    public ResponseEntity<CourseUpdateResponseDto> registerUsers(@RequestBody CourseParticipantsDto courseParticipantsDto) {
        log.info("Add students - {}", courseParticipantsDto);
        CourseUpdateResponseDto courseUpdateResponseDto = courseService.addCourseParticipants(courseParticipantsDto);
        return ResponseEntity.status(courseUpdateResponseDto.getStatus()).body(courseUpdateResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CourseRegisterResponseDto>> getCourses(@PageableDefault(size = 2) Pageable pageable) {
        log.info("Get courses - {}", pageable.toString());
        List<CourseRegisterResponseDto> courses = courseService.getCourses(pageable);
        return ResponseEntity.ok(courses);
    }
}
