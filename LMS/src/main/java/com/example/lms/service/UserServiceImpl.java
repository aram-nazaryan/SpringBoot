package com.example.lms.service;

import com.example.lms.domain.*;
import com.example.lms.domain.enums.Role;
import com.example.lms.dto.*;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.dto.feedback.*;
import com.example.lms.mapper.AssessmentMapper;
import com.example.lms.mapper.UserMapper;
import com.example.lms.repository.*;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserHomeworkRepository userHomeworkRepository;
    private final AssessmentRepository assessmentRepository;
    private final UserAssessmentRepository userAssessmentRepository;
    private final CourseRepository courseRepository;
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private final AssessmentMapper assessmentMapper = Mappers.getMapper(AssessmentMapper.class);

    @Override
    public UserRegisterResponseDto register(UserRegisterDto userRegisterDto) {
        if (!isBodyValid(userRegisterDto)) {
            ErrorDto errorDto = ErrorType.INVALID_BODY.errorDto();
            return new UserRegisterResponseDto(errorDto);
        }

        User user = userMapper.userDtoToUser(userRegisterDto);
        try {
            User newUser = userRepository.save(user);
            return userMapper.userToUserResponseDto(newUser);
        } catch (Exception e) {
            ErrorDto errorDto = ErrorType.ALREADY_REGISTERED.errorDto();
            return new UserRegisterResponseDto(errorDto);
        }
    }

    @Override
    public List<UserRegisterResponseDto> getUsers(Pageable pageable) {
        Page<User> all = userRepository.findAll(pageable);
        return all
                .stream()
                .map(userMapper::userToUserResponseDto)
                .toList();
    }

    @Override
    public UpdateResponseMessageDto delete(String uuid) {
        User user = userRepository.findUsersByUuid(uuid);
        if (user != null) {
            userRepository.delete(user);
            return new UpdateResponseMessageDto(Message.DELETE_USER.getMessage());
        }

        ErrorDto errorDto = ErrorType.USER_NOT_EXISTS.errorDto();
        return new UpdateResponseMessageDto(errorDto);
    }

    @Override
    public List<UserRegisterResponseDto> getUsersByRole(String role) {
        if (!(role.equals("trainer") || role.equals("student"))) {
            ErrorDto errorDto = ErrorType.INCORRECT_USER_TYPE.errorDto();
            UserRegisterResponseDto registerResponseDto = new UserRegisterResponseDto(errorDto);
            return List.of(registerResponseDto);
        }

        List<User> users = userRepository.findUsersByRole(role.equals("trainer") ? Role.ROLE_TRAINER : Role.ROLE_STUDENT);
        return users
                .stream()
                .map(userMapper::userToUserResponseDto)
                .toList();
    }

    @Override
    public UserDetailsDto get(String uuid) {
        User user = userRepository.findUsersByUuid(uuid);
        if (user == null) {
            ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
            return new UserDetailsDto(errorDto);
        }

        UserDetailsDto userDetailsDto = userMapper.userToUserDetailsDto(user);
        List<UserAssessment> userAssessments = user.getUserAssessments();
        Set<Integer> numbers = userAssessments
                .stream()
                .map(u -> u.getAssessment().getNumber())
                .collect(Collectors.toSet());
        userDetailsDto.setNumbers(numbers);
        return userDetailsDto;
    }

    @Override
    public FeedbackDto getFeedback(FeedbackRequestDto feedbackRequestDto) {
        User user = userRepository.findUsersByUuid(feedbackRequestDto.getUuid());
        FeedbackDto feedback = userMapper.userToFeedbackDto(user);
        Set<CourseDto> courseDtos = new HashSet<>();
        List<Course> courses = courseRepository.findAllByUuidIn(feedbackRequestDto.getUuids());
        for (Course c : courses) {
            CourseDto courseDto = new CourseDto();
            courseDto.setName(c.getName());
            List<SessionFeedbackDto> sessionFeedbackDtos = new ArrayList<>();
            for (Session s : c.getSessions()) {
                SessionFeedbackDto sessionFeedbackDto = new SessionFeedbackDto();
                Homework homework = s.getHomework();
                if (homework != null) {
                    UserHomework userHomework = userHomeworkRepository.findByHomework_IdAndUser_Id(homework.getId(), user.getId());
                    sessionSetter(userHomework, s, sessionFeedbackDto);
                    sessionFeedbackDtos.add(sessionFeedbackDto);
                }
            }
            courseDto.setSessions(sessionFeedbackDtos);
            courseDtos.add(courseDto);
        }
        feedback.setCourses(courseDtos);

        List<Assessment> assessments = assessmentRepository.findAllByNumberIn(feedbackRequestDto.getAssessmentNumbers());
        List<AssessmentDto> assessmentDtos = new ArrayList<>();
        for (Assessment a : assessments) {
            AssessmentDto assessmentDto = new AssessmentDto();
            assessmentDto.setNumber(a.getNumber());
            List<UserAssessment> userAssessments = userAssessmentRepository.findAllByAssessment_IdAndUser_Id(a.getId(), user.getId());
            List<UserAssessmentFeedbackDto> list = userAssessments
                    .stream()
                    .map(assessmentMapper::userAssessmentToFeedbackDto)
                    .toList();
            assessmentDto.setAssessmentFeedbackDtos(list);
            assessmentDtos.add(assessmentDto);
        }
        feedback.setAssessments(assessmentDtos);
        return feedback;
    }

    private void sessionSetter(UserHomework userHomework, Session s, SessionFeedbackDto sessionFeedbackDto) {
        sessionFeedbackDto.setNumber(s.getNumber());
        sessionFeedbackDto.setGrade(userHomework.getGrade());
        sessionFeedbackDto.setPassedStatus(userHomework.getPassedStatus());
        sessionFeedbackDto.setComment(userHomework.getComment());
    }

    private Boolean isBodyValid(UserRegisterDto registerDto) {
        return registerDto.getEmail() != null &&
                registerDto.getRole() != null &&
                registerDto.getFirstName() != null &&
                registerDto.getLastName() != null &&
                registerDto.getPhoneNumber() != null;
    }
}
