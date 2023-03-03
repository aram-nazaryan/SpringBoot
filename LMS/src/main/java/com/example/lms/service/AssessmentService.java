package com.example.lms.service;

import com.example.lms.dto.AssessmentRequestDto;
import com.example.lms.dto.AssessmentResponseDto;
import com.example.lms.dto.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;

import java.util.List;

public interface AssessmentService {
    UpdateResponseMessageDto create(AssessmentRequestDto assessmentRequestDto);
    UpdateResponseMessageDto update(AssessmentUpdateRequestDto assessmentRequestDto);

    List<AssessmentResponseDto> get ();
}
