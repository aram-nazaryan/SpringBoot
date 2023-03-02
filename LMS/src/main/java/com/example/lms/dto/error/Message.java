package com.example.lms.dto.error;

import lombok.Getter;

@Getter
public enum Message {
    UPDATE("Course updated"),
    DELETE("Course deleted"),
    DELETE_USER("User deleted"),
    ATTENDANCE_UPDATED("Attendance updated"),
    HOMEWORK_UPDATED("Homework updated");

    private final String message;

    Message(String message) {
        this.message = message;
    }
}
