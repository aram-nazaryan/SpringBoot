package com.example.lms.repository;

import com.example.lms.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Page<User> findAll(Pageable pageable);

    List<User> findUsersByUuidIn(List<String> uuids);

    User findUsersByUuid(String uuid);

}
