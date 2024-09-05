package dk.cph.dto;

import dk.cph.model.Course;
import dk.cph.model.CourseName;
import dk.cph.model.Student;
import dk.cph.model.Teacher;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CourseDTO {



    private LocalDate startDate;


    private LocalDate endDate;


    private CourseName courseName;


    private Set<StudentDTO> students = new HashSet<>();


    private TeacherDTO teacher;


    public CourseDTO(Course course) {
        this.courseName = course.getCourseName();
        this.startDate = course.getStartDate();
        this.endDate = course.getEndDate();
        this.teacher = new TeacherDTO(course.getTeacher());
        for (Student student : course.getStudents()) {
            StudentDTO studentDTO = new StudentDTO(student);
            this.students.add(studentDTO);
        }

    }


}
