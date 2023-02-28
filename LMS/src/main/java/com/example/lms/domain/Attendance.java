package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "ATTENDANCE")
@Entity
public class Attendance {
    @Id
    @SequenceGenerator(
            name = "attendance_sequence",
            sequenceName = "attendance_sequence_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "attendance_sequence"
    )
    private Long id;

    @Column(name = "present")
    private Boolean attendedStatus;

    @ManyToOne
    private User user;

    @ManyToOne
    private Session session;
}
