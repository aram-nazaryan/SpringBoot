package com.example.lms.mapper;

import com.example.lms.domain.User;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-28T13:59:04+0400",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.jar, environment: Java 18.0.2-ea (Private Build)"
)
public class UserMapperImpl implements UserMapper {

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
}
