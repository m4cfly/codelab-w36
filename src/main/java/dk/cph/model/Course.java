package dk.cph.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "courses")
@NoArgsConstructor
@Getter
@ToString
public class Course {
    // test

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column (name = "course_name", nullable = false)
    @Enumerated(EnumType.STRING)
    private CourseName courseName;



}


