package com.example.lms.service;

import com.example.lms.dto.HomeworkCreationDto;
import com.example.lms.dto.HomeworkResponseDto;

public interface HomeworkService {
    HomeworkResponseDto createHomework (HomeworkCreationDto creationDto);
}
