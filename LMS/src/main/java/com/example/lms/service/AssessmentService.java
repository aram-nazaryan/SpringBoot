package com.example.lms.service;

import com.example.lms.dto.AssessmentRequestDto;
import com.example.lms.dto.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;

public interface AssessmentService {
    UpdateResponseMessageDto create(AssessmentRequestDto assessmentRequestDto);
    UpdateResponseMessageDto update(AssessmentUpdateRequestDto assessmentRequestDto);
}
