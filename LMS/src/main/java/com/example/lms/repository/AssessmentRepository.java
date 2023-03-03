package com.example.lms.repository;

import com.example.lms.domain.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
    List<Assessment> findAllByNumberIn(List<Integer> numbers);
}
