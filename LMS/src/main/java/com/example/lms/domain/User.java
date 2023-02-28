package com.example.lms.domain;

import com.example.lms.domain.enums.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence_seq",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id;

    @Column(name = "uuid", unique = true, nullable = false, updatable = false)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;

    @Column(name = "password")
    private String password;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "REGISTERED_DATE", updatable = false, nullable = false)
    private LocalDateTime registeredAt;
    @LastModifiedDate
    @Column(name = "LAST_MODIFICATION", nullable = false)
    @UpdateTimestamp
    private LocalDateTime modifiedAt;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_course",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonBackReference
    private Set<Course> courses;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserAssessment> userAssessments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<UserHomework> userTasks;

}
