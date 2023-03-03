package com.example.lms.service;

import com.example.lms.dto.assessment.AssessmentRequestDto;
import com.example.lms.dto.assessment.AssessmentResponseDto;
import com.example.lms.dto.assessment.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;

import java.util.List;

public interface AssessmentService {
    UpdateResponseMessageDto create(AssessmentRequestDto assessmentRequestDto);
    UpdateResponseMessageDto update(AssessmentUpdateRequestDto assessmentRequestDto);

    List<AssessmentResponseDto> get ();
}
