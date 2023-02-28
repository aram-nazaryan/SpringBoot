package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"number", "course_id", "user_id"})
        }
)
public class UserAssessment {
    @Id
    @GeneratedValue
    private Long id;

    private Integer number;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "grade")
    private Double grade;

    @Column(name = "passed")
    private Boolean passedStatus;
}
