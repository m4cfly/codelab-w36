package dk.cph;


import dk.cph.model.Course;
import dk.cph.model.CourseName;
import dk.cph.model.Student;
import dk.cph.model.Teacher;
import jakarta.persistence.EntityManagerFactory;
import dk.cph.config.HibernateConfig;

import java.io.ObjectInputFilter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory(false);

        Student student = new Student("Jon", "jon@haha");
        Student student2 = new Student("Nicklas", "nicklas@haha");
        Student student3 = new Student("William", "william@haha");
        Student student4 = new Student("Jenny", "jenny@haha");

        Teacher teacher = new Teacher("Kong Frederik", "kong@danmark", "kingkong@com");
        Teacher teacher2 = new Teacher("Lærer Line", "lærnogetfedt@com", "hvadlaverdu@com");
        Teacher teacher3 = new Teacher("Professor Programmør", "prof@com", "propro@com");
        Teacher teacher4 = new Teacher("Tobias", "tobias@com", "tob@com");


        Course course1 = new Course("hej", LocalDate.of(2023, 4, 7), LocalDate.of(2025, 7, 28), CourseName.MUSIC, teacher);
        Course course2 = new Course("hej", LocalDate.of(2023, 4, 9), LocalDate.of(2025, 9, 28), CourseName.SCIENCE, teacher3);
        Course course3 = new Course("hej", LocalDate.of(2024, 11, 9), LocalDate.of(2026, 10, 28), CourseName.SPORTS, teacher3);
        Course course4 = new Course("hej", LocalDate.of(2024, 10, 9), LocalDate.of(2026, 9, 28), CourseName.SPORTS, teacher4);
        Course course5 = new Course("hej", LocalDate.of(2024, 4, 17), LocalDate.of(2025, 4, 28), CourseName.ENGLISH, teacher2);


        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();


            em.getTransaction().commit();


        }
    }
}