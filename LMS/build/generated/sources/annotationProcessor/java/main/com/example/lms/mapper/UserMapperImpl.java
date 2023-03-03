package com.example.lms.mapper;

import com.example.lms.domain.Course;
import com.example.lms.domain.Session;
import com.example.lms.domain.User;
import com.example.lms.dto.UserDetailsDto;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import com.example.lms.dto.course.CourseRegisterResponseDto;
import com.example.lms.dto.feedback.CourseDto;
import com.example.lms.dto.feedback.FeedbackDto;
import com.example.lms.dto.feedback.SessionFeedbackDto;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.mapstruct.factory.Mappers;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-03-03T22:51:10+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 18.0.2-ea (Private Build)"
)
public class UserMapperImpl implements UserMapper {

    private final CourseMapper courseMapper = Mappers.getMapper( CourseMapper.class );

    @Override
    public User userDtoToUser(UserRegisterDto registerDto) {
        if ( registerDto == null ) {
            return null;
        }

        User user = new User();

        user.setFirstName( registerDto.getFirstName() );
        user.setLastName( registerDto.getLastName() );
        user.setEmail( registerDto.getEmail() );
        user.setPhoneNumber( registerDto.getPhoneNumber() );
        user.setPassword( registerDto.getPassword() );
        user.setRole( registerDto.getRole() );

        return user;
    }

    @Override
    public UserRegisterResponseDto userToUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserRegisterResponseDto userRegisterResponseDto = new UserRegisterResponseDto();

        userRegisterResponseDto.setUuid( user.getUuid() );
        userRegisterResponseDto.setFirstName( user.getFirstName() );
        userRegisterResponseDto.setLastName( user.getLastName() );

        return userRegisterResponseDto;
    }

    @Override
    public UserDetailsDto userToUserDetailsDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setUuid( user.getUuid() );
        userDetailsDto.setFirstName( user.getFirstName() );
        userDetailsDto.setLastName( user.getLastName() );
        userDetailsDto.setEmail( user.getEmail() );
        userDetailsDto.setPhoneNumber( user.getPhoneNumber() );
        userDetailsDto.setRegisteredAt( user.getRegisteredAt() );
        userDetailsDto.setRole( user.getRole() );
        userDetailsDto.setCourses( courseSetToCourseRegisterResponseDtoList( user.getCourses() ) );

        return userDetailsDto;
    }

    @Override
    public FeedbackDto userToFeedbackDto(User user) {
        if ( user == null ) {
            return null;
        }

        FeedbackDto feedbackDto = new FeedbackDto();

        feedbackDto.setUuid( user.getUuid() );
        feedbackDto.setFirstName( user.getFirstName() );
        feedbackDto.setLastName( user.getLastName() );
        feedbackDto.setCourses( courseSetToCourseDtoSet( user.getCourses() ) );

        return feedbackDto;
    }

    protected List<CourseRegisterResponseDto> courseSetToCourseRegisterResponseDtoList(Set<Course> set) {
        if ( set == null ) {
            return null;
        }

        List<CourseRegisterResponseDto> list = new ArrayList<CourseRegisterResponseDto>( set.size() );
        for ( Course course : set ) {
            list.add( courseMapper.courseToResponseDto( course ) );
        }

        return list;
    }

    protected SessionFeedbackDto sessionToSessionFeedbackDto(Session session) {
        if ( session == null ) {
            return null;
        }

        SessionFeedbackDto sessionFeedbackDto = new SessionFeedbackDto();

        sessionFeedbackDto.setNumber( session.getNumber() );

        return sessionFeedbackDto;
    }

    protected List<SessionFeedbackDto> sessionListToSessionFeedbackDtoList(List<Session> list) {
        if ( list == null ) {
            return null;
        }

        List<SessionFeedbackDto> list1 = new ArrayList<SessionFeedbackDto>( list.size() );
        for ( Session session : list ) {
            list1.add( sessionToSessionFeedbackDto( session ) );
        }

        return list1;
    }

    protected CourseDto courseToCourseDto(Course course) {
        if ( course == null ) {
            return null;
        }

        CourseDto courseDto = new CourseDto();

        courseDto.setName( course.getName() );
        courseDto.setSessions( sessionListToSessionFeedbackDtoList( course.getSessions() ) );

        return courseDto;
    }

    protected Set<CourseDto> courseSetToCourseDtoSet(Set<Course> set) {
        if ( set == null ) {
            return null;
        }

        Set<CourseDto> set1 = new LinkedHashSet<CourseDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Course course : set ) {
            set1.add( courseToCourseDto( course ) );
        }

        return set1;
    }
}
