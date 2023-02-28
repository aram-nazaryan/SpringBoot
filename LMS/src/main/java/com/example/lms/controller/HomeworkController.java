package com.example.lms.controller;

import com.example.lms.dto.HomeworkCreationDto;
import com.example.lms.dto.HomeworkResponseDto;
import com.example.lms.service.HomeworkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/homework")
@Slf4j
@RequiredArgsConstructor
public class HomeworkController {

    private final HomeworkService homeworkService;

    @PostMapping
    public ResponseEntity<HomeworkResponseDto> createHomework(@RequestBody HomeworkCreationDto creationDto) {
        log.info("Homework creation with body - {}", creationDto);
        HomeworkResponseDto homework = homeworkService.createHomework(creationDto);
        return ResponseEntity.status(homework.getStatus()).body(homework);
    }
}
