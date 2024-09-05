package dk.cph.dto;

import dk.cph.model.Course;
import dk.cph.model.Student;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class StudentDTO {


    private Integer id;


    private String name;


    private String email;


    private Set<Course> courses = new HashSet<>();


    public StudentDTO(Student student) {
        this.name = student.getName();
        this.email = student.getEmail();
        for (Course course : student.getCourses()) {
            this.courses.add(course);
        }

    }


}
