package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * StudentDaoImplement
 * Implementation of the {@link StudentDao} interface utilizing 
 * JPA {@link EntityManager} for CRUD operations on {@link Student} entities.
 * <p>
 * Annotated with {@link Repository} to qualify as a Spring Data repository 
 * component and handle automatic exception translation.
 * </p>
 *
 * @author Felisa Bascug
 */
@Repository 
public class StudentDaoImplement implements StudentDao {

    /**
     * JPA entity manager for performing database transactions.
     */
    private EntityManager em;

    /**
     * Constructs a new {@code StudentDaoImplement} with dependency injection.
     *
     * @param em the JPA {@link EntityManager} instance
     */
    public StudentDaoImplement(EntityManager em) {
        this.em = em;
    }

    @Override 
    @Transactional // ensures actions are treated as single unit of work
    public void save(Student theStudent) {
        em.persist(theStudent);
    }

    @Override 
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = em.createQuery
                            ("FROM Student order by lastName", Student.class);
        
        // return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = em.createQuery
                    ("FROM Student WHERE lastName=:data", Student.class);
        
        // set parameter
        query.setParameter("data", lastName);

        // return query results
        return query.getResultList();
    }

    @Override 
    @Transactional 
    public void update(Student theStudent) {
        em.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve student
        Student student = em.find(Student.class, id);

        // delete student
        em.remove(student);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRows = em.createQuery("DELETE FROM Student").executeUpdate();
        return numRows;
    }

}