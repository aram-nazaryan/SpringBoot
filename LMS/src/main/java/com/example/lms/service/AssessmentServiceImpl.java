package com.example.lms.service;

import com.example.lms.domain.Assessment;
import com.example.lms.domain.Course;
import com.example.lms.domain.User;
import com.example.lms.domain.UserAssessment;
import com.example.lms.domain.enums.Role;
import com.example.lms.dto.AssessmentRequestDto;
import com.example.lms.dto.AssessmentResponseDto;
import com.example.lms.dto.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.mapper.AssessmentMapper;
import com.example.lms.repository.AssessmentRepository;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.UserAssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final UserAssessmentRepository userAssessmentRepository;
    private final AssessmentRepository assessmentRepository;
    private final CourseRepository courseRepository;
    private final AssessmentMapper assessmentMapper = Mappers.getMapper(AssessmentMapper.class);
    @Override
    public UpdateResponseMessageDto create(AssessmentRequestDto assessmentRequestDto) {

        Set<User> users = new HashSet<>();
        Set<Course> courses = new HashSet<>();
        for (String uuid : assessmentRequestDto.getUuids()) {
            Course course = courseRepository.getCoursesByUuid(uuid);
            users.addAll(course.getUsers());
            courses.add(course);
        }

        Assessment assessment = new Assessment();
        assessment.setNumber(assessmentRequestDto.getNumber());
        assessmentRepository.save(assessment);

        for (User u : users) {
            if (u.getRole().equals(Role.ROLE_TRAINER))
                continue;
            for (Course c : courses) {
                UserAssessment userAssessment = new UserAssessment();
                userAssessment.setAssessment(assessment);
                userAssessment.setCourse(c);
                userAssessment.setUser(u);
                userAssessmentRepository.save(userAssessment);
            }
        }

        return new UpdateResponseMessageDto(Message.ASSESSMENT_CREATED.getMessage());

    }

    @Override
    public UpdateResponseMessageDto update(AssessmentUpdateRequestDto assessmentRequestDto) {
        UserAssessment assessment = userAssessmentRepository.findByUser_IdAndCourse_IdAndAssessment_Id(assessmentRequestDto.getUserId(), assessmentRequestDto.getCourseId(), assessmentRequestDto.getAssessmentId());
        if (assessment == null) {
            ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
            return new UpdateResponseMessageDto(errorDto);
        }
        assessment.setGrade(assessmentRequestDto.getGrade());
        assessment.setComment(assessmentRequestDto.getComment());
        assessment.setPassedStatus(assessmentRequestDto.getPassedStatus());

        userAssessmentRepository.save(assessment);
        return new UpdateResponseMessageDto(Message.ASSESSMENT_UPDATED.getMessage());
    }

    @Override
    public List<AssessmentResponseDto> get() {
        List<Assessment> assessments = assessmentRepository.findAll();
        return assessments
                .stream()
                .map(assessmentMapper::assessmentToDto)
                .toList();
    }
}
