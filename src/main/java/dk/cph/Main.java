package dk.cph;


import dk.cph.model.*;
import jakarta.persistence.EntityManagerFactory;
import dk.cph.config.HibernateConfig;

import java.io.ObjectInputFilter;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactory(false);

        // laver entities:

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

        GradeSheet g1 = new GradeSheet(CourseName.MUSIC, GradeScale.C);
        GradeSheet g2 = new GradeSheet(CourseName.SCIENCE, GradeScale.A);
        GradeSheet g3 = new GradeSheet(CourseName.SPORTS, GradeScale.B);
        GradeSheet g4 = new GradeSheet(CourseName.ENGLISH, GradeScale.F);



        // tilføjer teachers og students til courses og students til gradesheets:
        // pga. one-to-one relation mellem Student og GradeSheet, kan en student max have en gradesheet, og en gradesheet max have en student

        course1.addTeacher(teacher);
        course1.addStudent(student);
        course1.addStudent(student2);
        g1.addStudent(student);
//        g2.addStudent(student2);

        course2.addTeacher(teacher3);
        course2.addStudent(student3);
        g2.addStudent(student3);

        course3.addTeacher(teacher4);
        course3.addStudent(student4);
        course3.addStudent(student);
        g3.addStudent(student4);
//        g5.addStudent(student);

        course4.addTeacher(teacher2);
        course4.addStudent(student2);
        course4.addStudent(student3);
//        g6.addStudent(student2);
//        g7.addStudent(student3);


        course5.addTeacher(teacher3);
        course5.addStudent(student4);
        g4.addStudent(student2);





        // persister vores entities til databasen:

        try (var em = emf.createEntityManager()) {
            em.getTransaction().begin();

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);
            em.persist(course5);

            em.persist(teacher);
            em.persist(teacher2);
            em.persist(teacher3);
            em.persist(teacher4);

            em.persist(student);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);

            em.persist(g1);
            em.persist(g2);
            em.persist(g3);
            em.persist(g4);
//            em.persist(g5);
//            em.persist(g6);
//            em.persist(g7);
//            em.persist(g8);

//            em.find(Course.class, course1.getId());
//            em.find(Course.class, course2.getId());
//            em.find(Course.class, course3.getId());
//            em.find(Course.class, course4.getId());
//            em.find(Teacher.class, teacher3.getId());
//            em.find(Teacher.class, teacher4.getId());
            //em.remove(course1);
//            em.contains("hej");


            em.getTransaction().commit();


        }
    }
}