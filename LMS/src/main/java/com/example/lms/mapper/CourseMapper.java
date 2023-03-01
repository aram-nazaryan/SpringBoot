package com.example.lms.mapper;

import com.example.lms.domain.*;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.course.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CourseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "users", ignore = true)
    @Mapping(target = "sessions", ignore = true)
    @Mapping(target = "userAssessments", ignore = true)
    Course courseDtoToCourse(CourseRegisterDto courseRegisterDto);

    CourseRegisterResponseDto courseToResponseDto(Course course);

    CourseDetailsResponseDto courseToDetailsDto(Course course);

    @Mapping(source = "course.id", target = "courseId")
    SessionDto sessionToSessionDto(Session session);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "session.id", target = "sessionId")
    AttendanceDto attendanceToAttendanceDto(Attendance attendance);

    @Mapping(target = "sessionId", source = "session.id")
    HomeworkDto homeworkToHomeworkDto (Homework homework);

    @Mapping(target = "homeworkId", source = "homework.id")
    @Mapping(target = "userId", source = "user.id")
    UserHomeworkDto userHomeToUserHomeDto(UserHomework userHomework);
}

