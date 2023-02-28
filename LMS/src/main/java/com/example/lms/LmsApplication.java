package com.example.lms;

import com.example.lms.domain.Course;
import com.example.lms.repository.CourseRepository;
import com.example.lms.repository.HomeworkRepository;
import com.example.lms.repository.SessionRepository;
import com.example.lms.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@SpringBootApplication
public class LmsApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LmsApplication.class, args);
        CourseRepository courseRepository = run.getBean(CourseRepository.class);

        Pageable pageable = PageRequest.of(0, 2);
        Page<Course> all = courseRepository.findAll(pageable);


        System.out.println("-----------------");
    }

}
