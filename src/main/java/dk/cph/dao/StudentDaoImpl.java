package dk.cph.dao;


import dk.cph.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentDaoImpl implements GenericDAO <Student, Integer> {


    private static StudentDaoImpl instance;
    private static EntityManagerFactory emf;

    public static StudentDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StudentDaoImpl();
        }
        return instance;
    }

    @Override
    public List findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.find(Student.class, findAll());
            em.getTransaction().commit();
            return em.createQuery("select s from Student s").getResultList();
        }
    }

    @Override
    public void persistEntity(Student student) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();

        }
    }

    @Override
    public void removeEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Student student = em.find(Student.class, id);
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
        }

    }

    @Override
    public Student findEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Student student = em.find(Student.class, id);
            return student;
        }
    }

    @Override
    public Student updateEntity(Student student, Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Student updatedStudent = em.merge(student);
            em.getTransaction().commit();
            return updatedStudent;
        }
    }





}
