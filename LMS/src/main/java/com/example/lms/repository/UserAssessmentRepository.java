package com.example.lms.repository;

import com.example.lms.domain.UserAssessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAssessmentRepository extends JpaRepository<UserAssessment, Long> {
    UserAssessment findByUser_IdAndCourse_IdAndAssessment_Id(Long userId, Long courseId, Long assessmentId);
    List<UserAssessment> findAllByAssessment_IdAndUser_Id(Long assessmentId, Long userId);
}
