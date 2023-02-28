package com.example.lms.repository;

import com.example.lms.domain.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> getSessionsByCourse_Uuid(String uudi);
    Session getSessionByCourse_UuidAndNumber(String uuid, Integer number);
}
