package com.example.lms.mapper;

import com.example.lms.domain.Assessment;
import com.example.lms.domain.UserAssessment;
import com.example.lms.dto.AssessmentResponseDto;
import com.example.lms.dto.UserAssessmentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(uses = {UserMapper.class, CourseMapper.class})
@Component
public interface AssessmentMapper {
    AssessmentResponseDto assessmentToDto(Assessment assessment);

    @Mapping(target = "assessmentId", source = "assessment.id")
    @Mapping(target = "courseId", source = "course.id")
    @Mapping(target = "userId", source = "user.id")
    UserAssessmentDto userAssessmentToDto (UserAssessment userAssessment);
}
