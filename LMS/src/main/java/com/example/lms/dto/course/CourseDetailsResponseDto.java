package com.example.lms.dto.course;

import com.example.lms.domain.Session;
import com.example.lms.dto.AbstractResponseDto;
import com.example.lms.dto.error.ErrorDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class CourseDetailsResponseDto extends AbstractResponseDto {

    private String uuid;

    private String name;

    private Integer numberOfSessions;

    private LocalDate startDate;

    private LocalDate endDate;
    private List<SessionDto> sessions;

    public CourseDetailsResponseDto () {};
    public CourseDetailsResponseDto (ErrorDto errorDto) {super(errorDto);};
}
