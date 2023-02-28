package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserHomework {

    @Id
    @SequenceGenerator(
            name = "tasks_sequence",
            sequenceName = "task_sequence_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "tasks_sequence"
    )
    private Long id;

    @Column(name = "comment", columnDefinition = "text")
    private String comment;

    @Column(name = "grade")
    private Double grade;

    @Column(name = "passed")
    private Boolean passedStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Homework homework;
}
