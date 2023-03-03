package com.example.lms.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssessmentRequestDto {
    private Integer number;
    private List<String> uuids;
}
