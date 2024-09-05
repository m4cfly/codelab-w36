package dk.cph.dto;

import dk.cph.model.Course;
import dk.cph.model.Teacher;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

public class TeacherDTO {


    private Integer id;


    private String name;


    private String zoom;


    private Set<Course> courses = new HashSet<>();

    public TeacherDTO(Teacher teacher) {
        this.name = teacher.getName();
        this.zoom = teacher.getZoom();
        for (Course course : teacher.getCourses()) {
            this.courses.add(course);
        }

    }







}
