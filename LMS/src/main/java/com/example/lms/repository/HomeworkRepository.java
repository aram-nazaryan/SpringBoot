package com.example.lms.repository;

import com.example.lms.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeworkRepository extends JpaRepository<Homework, Long> {
    Homework getHomeworkBySession_Id(Long id);
}
