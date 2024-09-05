package dk.cph.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();


    @ManyToOne
    private Teacher teacher;

    public Course(String description, LocalDate startDate, LocalDate endDate, CourseName courseName, Teacher teacher) {
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.courseName = courseName;
        this.teacher = teacher;
    }


//    public Course(String description, LocalDate startDate, LocalDate endDate, CourseName courseName, Set<Student> students, Teacher teacher) {
//        this.description = description;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.courseName = courseName;
//        this.students = students;
//        this.teacher = teacher;
//    }


    public void addTeacher (Teacher teacher) {
        if (teacher != null) {
            this.teacher = teacher;
        }
    }


    public void addStudentToCourse (Student student) {
        if (student != null) {
            this.students.add(student);
            student.getCourses().add(this);
        }
    }


}


