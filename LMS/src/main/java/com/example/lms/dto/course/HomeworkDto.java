package com.example.lms.dto.course;

import com.example.lms.domain.UserHomework;
import lombok.Data;

import java.util.List;

@Data
public class HomeworkDto {

    private Long id;
    private Long sessionId;
    private List<UserHomeworkDto> userHomework;

}
