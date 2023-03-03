package com.example.lms.mapper;

import com.example.lms.domain.*;
import com.example.lms.dto.course.CourseRegisterDto;
import com.example.lms.dto.course.CourseRegisterResponseDto;
import com.example.lms.dto.course.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
    @Mapping(target = "userName", source = "user.firstName")
    @Mapping(target = "userSurname", source = "user.lastName")
    AttendanceDto attendanceToAttendanceDto(Attendance attendance);

    @Mapping(target = "sessionId", source = "session.id")
    HomeworkDto homeworkToHomeworkDto (Homework homework);

    @Mapping(target = "homeworkId", source = "homework.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "userName", source = "user.firstName")
    @Mapping(target = "userSurname", source = "user.lastName")
    UserHomeworkDto userHomeToUserHomeDto(UserHomework userHomework);
}

