package com.example.lms.repository;

import com.example.lms.domain.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findBySession_IdAndUser_Id(Long sessionId, Long userId);
}
