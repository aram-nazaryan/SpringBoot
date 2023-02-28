package com.example.lms.domain;

import com.example.lms.domain.enums.TaskType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Table(name = "Homeworks")
@Entity
@Getter
@Setter
public class Homework {
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

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private TaskType taskType = TaskType.HOMEWORK;


    @OneToOne
    @JoinColumn(name = "session_id", unique = true, nullable = false)
    private Session session;

    @OneToMany(mappedBy = "homework", cascade = CascadeType.REMOVE)
    private List<UserHomework> userHomework;

}
