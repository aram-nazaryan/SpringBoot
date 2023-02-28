package com.example.lms.mapper;

import com.example.lms.domain.User;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper
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

    @Mapping(source = "uuid", target = "uuid")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    UserRegisterResponseDto userToUserResponseDto(User user);
}
