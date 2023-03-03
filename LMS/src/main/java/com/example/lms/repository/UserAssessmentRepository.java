package com.example.lms.repository;

import com.example.lms.domain.UserAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAssessmentRepository extends JpaRepository<UserAssessment, Long> {
    UserAssessment findByUser_IdAndCourse_IdAndNumber(Long userId, Long courseId, Integer number);
}
