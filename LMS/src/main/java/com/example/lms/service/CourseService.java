package com.example.lms.service;

import com.example.lms.dto.CourseParticipantsDto;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {

    CourseRegisterResponseDto register(CourseRegisterDto courseRegisterDto);

    List<CourseRegisterResponseDto> getCourses(Pageable pageable);

    UpdateResponseMessageDto addCourseParticipants(CourseParticipantsDto participantsDto);

    UpdateResponseMessageDto delete(String uuid);
}
