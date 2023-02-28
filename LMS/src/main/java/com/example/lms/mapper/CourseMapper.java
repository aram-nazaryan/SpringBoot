package com.example.lms.mapper;

import com.example.lms.domain.Course;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
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

    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "name", target = "name")
    CourseRegisterResponseDto courseToResponseDto(Course course);
}

