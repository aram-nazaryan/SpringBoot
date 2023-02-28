package com.example.lms.repository;

import com.example.lms.domain.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAll(Pageable pageable);
    Course getCoursesByUuid (String uuid);

}