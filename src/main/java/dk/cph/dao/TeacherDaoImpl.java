package dk.cph.dao;

import dk.cph.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TeacherDaoImpl implements GenericDAO<Teacher, Integer> {

    private static TeacherDaoImpl instance;
    private static EntityManagerFactory emf;

    public static TeacherDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new TeacherDaoImpl();
        }
        return instance;
    }
    @Override
    public List findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.find(Teacher.class, findAll());
            em.getTransaction().commit();
            return em.createQuery("select t from Teacher t").getResultList();
        }
    }
    @Override
    public void persistEntity(Teacher teacher) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(teacher);
            em.getTransaction().commit();

        }
    }

    @Override
    public void removeEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Teacher teacher = em.find(Teacher.class, id);
            em.getTransaction().begin();
            em.remove(teacher);
            em.getTransaction().commit();
        }

    }

    @Override
    public Teacher findEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Teacher teacher = em.find(Teacher.class, id);
            return teacher;
        }
    }

    @Override
    public Teacher updateEntity(Teacher teacher, Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Teacher updatedTeacher = em.merge(teacher);
            em.getTransaction().commit();
            return updatedTeacher;
        }
    }
}
