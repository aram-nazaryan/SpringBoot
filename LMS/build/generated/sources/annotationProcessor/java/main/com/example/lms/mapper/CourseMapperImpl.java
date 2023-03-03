package com.example.lms.mapper;

import com.example.lms.domain.Attendance;
import com.example.lms.domain.Course;
import com.example.lms.domain.Homework;
import com.example.lms.domain.Session;
import com.example.lms.domain.User;
import com.example.lms.domain.UserHomework;
import com.example.lms.dto.CourseRegisterDto;
import com.example.lms.dto.CourseRegisterResponseDto;
import com.example.lms.dto.course.AttendanceDto;
import com.example.lms.dto.course.CourseDetailsResponseDto;
import com.example.lms.dto.course.HomeworkDto;
import com.example.lms.dto.course.SessionDto;
import com.example.lms.dto.course.UserHomeworkDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T16:18:52+0400",
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

    @Override
    public CourseDetailsResponseDto courseToDetailsDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDetailsResponseDto courseDetailsResponseDto = new CourseDetailsResponseDto();

        courseDetailsResponseDto.setUuid( course.getUuid() );
        courseDetailsResponseDto.setName( course.getName() );
        courseDetailsResponseDto.setNumberOfSessions( course.getNumberOfSessions() );
        courseDetailsResponseDto.setStartDate( course.getStartDate() );
        courseDetailsResponseDto.setEndDate( course.getEndDate() );
        courseDetailsResponseDto.setSessions( sessionListToSessionDtoList( course.getSessions() ) );

        return courseDetailsResponseDto;
    }

    @Override
    public SessionDto sessionToSessionDto(Session session) {
        if ( session == null ) {
            return null;
        }

        SessionDto sessionDto = new SessionDto();

        sessionDto.setCourseId( sessionCourseId( session ) );
        sessionDto.setId( session.getId() );
        sessionDto.setNumber( session.getNumber() );
        sessionDto.setAttendances( attendanceListToAttendanceDtoList( session.getAttendances() ) );
        sessionDto.setHomework( homeworkToHomeworkDto( session.getHomework() ) );

        return sessionDto;
    }

    @Override
    public AttendanceDto attendanceToAttendanceDto(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }

        AttendanceDto attendanceDto = new AttendanceDto();

        attendanceDto.setUserId( attendanceUserId( attendance ) );
        attendanceDto.setSessionId( attendanceSessionId( attendance ) );
        attendanceDto.setAttendedStatus( attendance.getAttendedStatus() );

        return attendanceDto;
    }

    @Override
    public HomeworkDto homeworkToHomeworkDto(Homework homework) {
        if ( homework == null ) {
            return null;
        }

        HomeworkDto homeworkDto = new HomeworkDto();

        homeworkDto.setSessionId( homeworkSessionId( homework ) );
        homeworkDto.setId( homework.getId() );
        homeworkDto.setUserHomework( userHomeworkListToUserHomeworkDtoList( homework.getUserHomework() ) );

        return homeworkDto;
    }

    @Override
    public UserHomeworkDto userHomeToUserHomeDto(UserHomework userHomework) {
        if ( userHomework == null ) {
            return null;
        }

        UserHomeworkDto userHomeworkDto = new UserHomeworkDto();

        userHomeworkDto.setHomeworkId( userHomeworkHomeworkId( userHomework ) );
        userHomeworkDto.setUserId( userHomeworkUserId( userHomework ) );
        userHomeworkDto.setComment( userHomework.getComment() );
        userHomeworkDto.setGrade( userHomework.getGrade() );
        userHomeworkDto.setPassedStatus( userHomework.getPassedStatus() );

        return userHomeworkDto;
    }

    protected List<SessionDto> sessionListToSessionDtoList(List<Session> list) {
        if ( list == null ) {
            return null;
        }

        List<SessionDto> list1 = new ArrayList<SessionDto>( list.size() );
        for ( Session session : list ) {
            list1.add( sessionToSessionDto( session ) );
        }

        return list1;
    }

    private Long sessionCourseId(Session session) {
        if ( session == null ) {
            return null;
        }
        Course course = session.getCourse();
        if ( course == null ) {
            return null;
        }
        Long id = course.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<AttendanceDto> attendanceListToAttendanceDtoList(List<Attendance> list) {
        if ( list == null ) {
            return null;
        }

        List<AttendanceDto> list1 = new ArrayList<AttendanceDto>( list.size() );
        for ( Attendance attendance : list ) {
            list1.add( attendanceToAttendanceDto( attendance ) );
        }

        return list1;
    }

    private Long attendanceUserId(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }
        User user = attendance.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long attendanceSessionId(Attendance attendance) {
        if ( attendance == null ) {
            return null;
        }
        Session session = attendance.getSession();
        if ( session == null ) {
            return null;
        }
        Long id = session.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long homeworkSessionId(Homework homework) {
        if ( homework == null ) {
            return null;
        }
        Session session = homework.getSession();
        if ( session == null ) {
            return null;
        }
        Long id = session.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<UserHomeworkDto> userHomeworkListToUserHomeworkDtoList(List<UserHomework> list) {
        if ( list == null ) {
            return null;
        }

        List<UserHomeworkDto> list1 = new ArrayList<UserHomeworkDto>( list.size() );
        for ( UserHomework userHomework : list ) {
            list1.add( userHomeToUserHomeDto( userHomework ) );
        }

        return list1;
    }

    private Long userHomeworkHomeworkId(UserHomework userHomework) {
        if ( userHomework == null ) {
            return null;
        }
        Homework homework = userHomework.getHomework();
        if ( homework == null ) {
            return null;
        }
        Long id = homework.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long userHomeworkUserId(UserHomework userHomework) {
        if ( userHomework == null ) {
            return null;
        }
        User user = userHomework.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
