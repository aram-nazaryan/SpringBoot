package com.example.lms.service;

import com.example.lms.domain.User;
import com.example.lms.dto.UserRegisterDto;
import com.example.lms.dto.UserRegisterResponseDto;
import com.example.lms.dto.error.ErrorDto;
import com.example.lms.dto.error.ErrorType;
import com.example.lms.mapper.UserMapper;
import com.example.lms.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

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

    private Boolean isBodyValid(UserRegisterDto registerDto) {
        return registerDto.getEmail() != null &&
                registerDto.getRole() != null &&
                registerDto.getFirstName() != null &&
                registerDto.getLastName() != null &&
                registerDto.getPhoneNumber() != null;
    }
}
