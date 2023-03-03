package com.example.lms.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Assessments")
@Getter
@Setter
public class Assessment {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private Integer number;
    @OneToMany(mappedBy = "assessment", cascade = CascadeType.REMOVE)
    private List<UserAssessment> assessments;
}

