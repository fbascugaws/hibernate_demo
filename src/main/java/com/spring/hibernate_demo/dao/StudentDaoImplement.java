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

    /**
     * Persists a new {@link Student} entity into the database.
     *
     * @param theStudent the {@link Student} object to save
     */
    @Override 
    @Transactional // ensures actions are treated as single unit of work
    public void save(Student theStudent) {
        em.persist(theStudent);
    }

    /**
     * Retrieves a {@link Student} by its primary key identifier.
     *
     * @param id the primary key ID of the student
     * @return the {@link Student} entity matching the given ID, 
     *          or {@code null} if not found
     */
    @Override 
    public Student findById(Integer id) {
        return em.find(Student.class, id);
    }

    /**
     * Retrieves all {@link Student} entities from the database.
     *
     * @return a {@link List} of all {@link Student} records
     */
    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> query = em.createQuery
                            ("FROM Student order by lastName", Student.class);
        
        // return query results
        return query.getResultList();
    }

    /**
     * Retrieves a list of {@link Student} entities matching 
     * the specified last name.
     *
     * @param lastName the last name to search for
     * @return a {@link List} of matching {@link Student} entities
     */
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

    /**
     * Updates an existing {@link Student} entity in the database.
     *
     * @param theStudent the {@link Student} object containing updated state
     */
    @Override 
    @Transactional 
    public void update(Student theStudent) {
        em.merge(theStudent);
    }

    /**
     * Deletes a {@link Student} entity identified by its primary key.
     *
     * @param id the primary key ID of the student to remove
     */
    @Override
    @Transactional
    public void delete(Integer id) {
        // retrieve student
        Student student = em.find(Student.class, id);

        // delete student
        em.remove(student);

    }

    /**
     * Deletes all {@link Student} records from the database table.
     *
     * @return the total number of records deleted
     */
    @Override
    @Transactional
    public int deleteAll() {
        int numRows = em.createQuery("DELETE FROM Student").executeUpdate();
        return numRows;
    }

}