package com.example.lms.service;

import com.example.lms.dto.course.CourseParticipantsDto;
import com.example.lms.dto.course.CourseRegisterDto;
import com.example.lms.dto.course.CourseRegisterResponseDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.CourseDetailsResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    CourseRegisterResponseDto register(CourseRegisterDto courseRegisterDto);

    List<CourseRegisterResponseDto> getCourses(Pageable pageable);

    UpdateResponseMessageDto addCourseParticipants(CourseParticipantsDto participantsDto);

    UpdateResponseMessageDto delete(String uuid);

    CourseDetailsResponseDto get(String uuid);
}
