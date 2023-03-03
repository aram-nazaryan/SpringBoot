package com.example.lms.repository;

import com.example.lms.domain.UserHomework;
import org.springframework.data.jpa.repository.JpaRepository;

public interface    UserHomeworkRepository extends JpaRepository<UserHomework, Long> {
    UserHomework findByHomework_IdAndUser_Id(Long homeworkId, Long userId);
}
