package com.example.lms.service;

import com.example.lms.domain.Course;
import com.example.lms.domain.User;
import com.example.lms.domain.UserAssessment;
import com.example.lms.domain.enums.Role;
import com.example.lms.dto.AssessmentRequestDto;
import com.example.lms.dto.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.UserAssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class AssessmentServiceImpl implements AssessmentService {

    private final UserAssessmentRepository assessmentRepository;
    private final CourseRepository courseRepository;
    @Override
    public UpdateResponseMessageDto create(AssessmentRequestDto assessmentRequestDto) {

        Set<User> users = new HashSet<>();
        Set<Course> courses = new HashSet<>();
        for (String uuid : assessmentRequestDto.getUuids()) {
            Course course = courseRepository.getCoursesByUuid(uuid);
            users.addAll(course.getUsers());
            courses.add(course);
        }

        for (User u : users) {
            if (u.getRole().equals(Role.ROLE_TRAINER))
                continue;
            for (Course c : courses) {
                UserAssessment assessment = new UserAssessment();
                assessment.setNumber(assessmentRequestDto.getNumber());
                assessment.setCourse(c);
                assessment.setUser(u);
                assessmentRepository.save(assessment);
            }
        }

        return new UpdateResponseMessageDto(Message.ASSESSMENT_CREATED.getMessage());

    }

    @Override
    public UpdateResponseMessageDto update(AssessmentUpdateRequestDto assessmentRequestDto) {
        UserAssessment assessment = assessmentRepository.findByUser_IdAndCourse_IdAndNumber(assessmentRequestDto.getUserId(), assessmentRequestDto.getCourseId(), assessmentRequestDto.getNumber());
        if (assessment == null) {
            ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
            return new UpdateResponseMessageDto(errorDto);
        }
        assessment.setGrade(assessmentRequestDto.getGrade());
        assessment.setComment(assessmentRequestDto.getComment());
        assessment.setPassedStatus(assessmentRequestDto.getPassedStatus());

        assessmentRepository.save(assessment);
        return new UpdateResponseMessageDto(Message.ASSESSMENT_UPDATED.getMessage());
    }
}
