package com.example.lms.mapper;

import com.example.lms.domain.User;
import com.example.lms.dto.feedback.FeedbackDto;
import com.example.lms.dto.UserDetailsDto;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = CourseMapper.class)
public interface UserMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "registeredAt", ignore = true)
    @Mapping(target = "modifiedAt", ignore = true)
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "attendances", ignore = true)
    @Mapping(target = "userAssessments", ignore = true)
    @Mapping(target = "userTasks", ignore = true)
    User userDtoToUser(UserRegisterDto registerDto);

    UserRegisterResponseDto userToUserResponseDto(User user);

    UserDetailsDto userToUserDetailsDto(User user);

    FeedbackDto userToFeedbackDto(User user);
}
