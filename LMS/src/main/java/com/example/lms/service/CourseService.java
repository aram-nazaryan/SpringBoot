package com.example.lms.service;

import com.example.lms.domain.Course;
import com.example.lms.dto.CourseParticipantsDto;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.CourseUpdateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    CourseRegisterResponseDto register(CourseRegisterDto courseRegisterDto);

    List<CourseRegisterResponseDto> getCourses(Pageable pageable);

    CourseUpdateResponseDto addCourseParticipants(CourseParticipantsDto participantsDto);
}
