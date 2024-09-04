package dk.cph.dao;

import dk.cph.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseDaoImpl implements GenericDAO <Course, Integer> {


    private static CourseDaoImpl instance;
    private static EntityManagerFactory emf;

    public static CourseDaoImpl getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CourseDaoImpl();
        }
        return instance;
    }

    @Override
    public List findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.find(Course.class, findAll());
            em.getTransaction().commit();
            return em.createQuery("select c from Course c").getResultList();
        }
    }

    @Override
    public void persistEntity(Course course) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();

        }
    }

    @Override
    public void removeEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Course course = em.find(Course.class, id);
            em.getTransaction().begin();
            em.remove(course);
            em.getTransaction().commit();
        }

    }

    @Override
    public Course findEntity(Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            Course course = em.find(Course.class, id);
            return course;
        }
    }

    @Override
    public Course updateEntity(Course entity, Integer id) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Course updatedCourse = em.merge(entity);
            em.getTransaction().commit();
            return updatedCourse;
        }
    }


}
