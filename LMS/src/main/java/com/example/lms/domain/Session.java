package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(
        name = "SESSIONS",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"number", "course_id"})
        }
)
public class Session {
    @Id
    @GeneratedValue
    private Long id;

    private Integer number;
    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "session", cascade = CascadeType.REMOVE)
    private List<Attendance> attendances;

    @OneToOne(mappedBy = "session", cascade = CascadeType.REMOVE)
    private Homework homework;
}
