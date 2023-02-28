package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;


@Entity
@Table(name = "COURSES")
@Data
public class Course {
    @Id
    @SequenceGenerator(
            name = "courses_sequence",
            sequenceName = "courses_sequence_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "courses_sequence"
    )
    private Long id;

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "number_of_sessions", nullable = false)
    private Integer numberOfSessions;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> users;


    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Session> sessions;

    @OneToMany(mappedBy = "course", cascade = CascadeType.REMOVE)
    private List<UserAssessment> userAssessments;
}
