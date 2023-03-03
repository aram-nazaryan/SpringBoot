package com.example.lms.service;

import com.example.lms.domain.*;
import com.example.lms.domain.enums.Role;
import com.example.lms.dto.HomeworkCreationDto;
import com.example.lms.dto.HomeworkResponseDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.UserHomeworkDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.HomeworkRepository;
import com.example.lms.repository.SessionRepository;
import com.example.lms.repository.UserHomeworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {

    private final HomeworkRepository homeworkRepository;
    private final SessionRepository sessionRepository;
    private final CourseRepository courseRepository;
    private final UserHomeworkRepository userHomeworkRepository;

    @Override
    public HomeworkResponseDto createHomework(HomeworkCreationDto creationDto) {
        Session session = sessionRepository.getSessionByCourse_UuidAndNumber(creationDto.getUuid(), creationDto.getNumber());
        if (session == null) {
            ErrorDto errorDto = ErrorType.INVALID_BODY.errorDto();
            return new HomeworkResponseDto(errorDto);
        }
        Homework homework = new Homework();
        homework.setSession(session);
        try {
            homeworkRepository.save(homework);
        } catch (Exception e) {
            ErrorDto errorDto = ErrorType.ALREADY_REGISTERED.errorDto();
            return new HomeworkResponseDto(errorDto);
        }

        Course course = courseRepository.getCoursesByUuid(creationDto.getUuid());
        Set<User> users = course.getUsers();

        for (User u : users) {
            if (u.getRole().equals(Role.ROLE_TRAINER))
                continue;
            UserHomework userHomework = new UserHomework();
            userHomework.setHomework(homework);
            userHomework.setUser(u);
            userHomeworkRepository.save(userHomework);
        }
        return new HomeworkResponseDto(course.getName(), session.getNumber());
    }

    @Override
    public UpdateResponseMessageDto updateUserHomework(UserHomeworkDto userHomeworkDto) {
        UserHomework homework = userHomeworkRepository.findByHomework_IdAndUser_Id(userHomeworkDto.getHomeworkId(), userHomeworkDto.getUserId());
        if (homework == null) {
            ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
            return new UpdateResponseMessageDto(errorDto);
        }
        homework.setComment(userHomeworkDto.getComment());
        homework.setGrade(userHomeworkDto.getGrade());
        homework.setPassedStatus(userHomeworkDto.getPassedStatus());

        userHomeworkRepository.save(homework);
        return new UpdateResponseMessageDto(Message.HOMEWORK_UPDATED.getMessage());
    }
}
