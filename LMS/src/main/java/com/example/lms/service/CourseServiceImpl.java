package com.example.lms.service;

import com.example.lms.domain.Attendance;
import com.example.lms.domain.Course;
import com.example.lms.domain.Session;
import com.example.lms.domain.User;
import com.example.lms.dto.CourseParticipantsDto;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.CourseDetailsResponseDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.dto.error.Message;
import com.example.lms.mapper.CourseMapper;
import com.example.lms.repository.AttendanceRepository;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.SessionRepository;
import com.example.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final SessionRepository sessionRepository;
    private final AttendanceRepository attendanceRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper = Mappers.getMapper(CourseMapper.class);

    @Override
    public CourseRegisterResponseDto register(CourseRegisterDto courseRegisterDto) {
        if (!invalidBody(courseRegisterDto)) {
            ErrorDto errorDto = ErrorType.INVALID_BODY.errorDto();
            return new CourseRegisterResponseDto(errorDto);
        }

        if (courseRegisterDto.getEndDate().isBefore(courseRegisterDto.getStartDate())) {
            ErrorDto errorDto = ErrorType.INVALID_BODY.errorDto();
            return new CourseRegisterResponseDto(errorDto);
        }

        Course course = courseMapper.courseDtoToCourse(courseRegisterDto);
        Course newCourse = courseRepository.save(course);

        List<Session> sessions = new ArrayList<>();
        for (int i = 1; i <= newCourse.getNumberOfSessions(); ++i) {
            Session session = new Session();
            session.setNumber(i);
            session.setCourse(newCourse);
            sessions.add(session);
        }

        newCourse.setSessions(sessions);
        courseRepository.save(newCourse);
        return courseMapper.courseToResponseDto(newCourse);
    }

    @Override
    public List<CourseRegisterResponseDto> getCourses(Pageable pageable) {
        Page<Course> all = courseRepository.findAll(pageable);
        List<CourseRegisterResponseDto> courses = all
                .stream()
                .map(courseMapper::courseToResponseDto)
                .toList();
        return courses;
    }

    @Override
    public UpdateResponseMessageDto addCourseParticipants(CourseParticipantsDto participantsDto) {
        Course course = courseRepository.getCoursesByUuid(participantsDto.getUuid());
        if (course == null) {
            ErrorDto errorDto = ErrorType.COURSE_NOT_FOUND.errorDto();
            return new UpdateResponseMessageDto(errorDto);
        }
        List<User> users = userRepository.findUsersByUuidIn(participantsDto.getUserUuids());
        Set<User> enrolledUsers = course.getUsers();

        List<Session> sessions = sessionRepository.getSessionsByCourse_Uuid(participantsDto.getUuid());
        for (User u : users) {
            if (!enrolledUsers.contains(u)) {
                for (Session s : sessions) {
                    Attendance attendance = new Attendance();
                    attendance.setUser(u);
                    attendance.setSession(s);
                    attendanceRepository.save(attendance);
                }
            }
        }
        enrolledUsers.addAll(users);
        course.setUsers(enrolledUsers);
        courseRepository.save(course);
        return new UpdateResponseMessageDto(Message.UPDATE.getMessage());
    }

    @Override
    public UpdateResponseMessageDto delete(String uuid) {
        Course course = courseRepository.getCoursesByUuid(uuid);
        if (course != null) {
            courseRepository.delete(course);
            return new UpdateResponseMessageDto(Message.DELETE.getMessage());
        }
        ErrorDto errorDto = ErrorType.NOT_EXISTS.errorDto();
        return new UpdateResponseMessageDto(errorDto);
    }

    @Override
    public CourseDetailsResponseDto get(String uuid) {
        Course course = courseRepository.getCoursesByUuid(uuid);
        if (course == null) {
            ErrorDto errorDto = ErrorType.COURSE_NOT_FOUND.errorDto();
            return new CourseDetailsResponseDto(errorDto);
        }

        CourseDetailsResponseDto details = courseMapper.courseToDetailsDto(course);
         return details;
    }


    private Boolean invalidBody(CourseRegisterDto registerDto) {
        return registerDto.getName() != null &&
                registerDto.getEndDate() != null &&
                registerDto.getStartDate() != null &&
                registerDto.getNumberOfSessions() != null;
    }
}
