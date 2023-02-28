package com.example.lms.mapper;

import com.example.lms.domain.Course;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-28T14:35:21+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 18.0.2-ea (Private Build)"
)
public class CourseMapperImpl implements CourseMapper {

    @Override
    public Course courseDtoToCourse(CourseRegisterDto courseRegisterDto) {
        if ( courseRegisterDto == null ) {
            return null;
        }

        Course course = new Course();

        course.setName( courseRegisterDto.getName() );
        course.setNumberOfSessions( courseRegisterDto.getNumberOfSessions() );
        course.setStartDate( courseRegisterDto.getStartDate() );
        course.setEndDate( courseRegisterDto.getEndDate() );

        return course;
    }

    @Override
    public CourseRegisterResponseDto courseToResponseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseRegisterResponseDto courseRegisterResponseDto = new CourseRegisterResponseDto();

        courseRegisterResponseDto.setUuid( course.getUuid() );
        courseRegisterResponseDto.setName( course.getName() );

        return courseRegisterResponseDto;
    }
}
