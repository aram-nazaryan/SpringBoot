package com.example.lms.service;

import com.example.lms.dto.HomeworkCreationDto;
import com.example.lms.dto.HomeworkResponseDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.dto.course.UserHomeworkDto;

public interface HomeworkService {
    HomeworkResponseDto createHomework (HomeworkCreationDto creationDto);

    UpdateResponseMessageDto updateUserHomework(UserHomeworkDto userHomeworkDto);
}
