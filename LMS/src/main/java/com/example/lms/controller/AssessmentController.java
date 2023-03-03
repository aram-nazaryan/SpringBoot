package com.example.lms.controller;

import com.example.lms.dto.AssessmentRequestDto;
import com.example.lms.dto.AssessmentResponseDto;
import com.example.lms.dto.AssessmentUpdateRequestDto;
import com.example.lms.dto.UpdateResponseMessageDto;
import com.example.lms.service.AssessmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessment")
@Slf4j
@RequiredArgsConstructor
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PostMapping("/create")
    public ResponseEntity<UpdateResponseMessageDto> create(@RequestBody AssessmentRequestDto requestDto) {
        log.info("Create assessment with body - {}", requestDto);
        UpdateResponseMessageDto assessment = assessmentService.create(requestDto);
        return ResponseEntity.status(assessment.getStatus()).body(assessment);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateResponseMessageDto> update(@RequestBody AssessmentUpdateRequestDto requestDto) {
        log.info("Update assessment info with body - {}", requestDto);
        UpdateResponseMessageDto update = assessmentService.update(requestDto);
        return ResponseEntity.status(update.getStatus()).body(update);
    }

    @GetMapping
    public ResponseEntity<List<AssessmentResponseDto>> get() {
        log.info("Get assessments");
        List<AssessmentResponseDto> assessments = assessmentService.get();
        return ResponseEntity.ok(assessments);
    }
}
