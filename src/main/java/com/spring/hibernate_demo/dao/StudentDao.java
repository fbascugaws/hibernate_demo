package com.spring.hibernate_demo.dao;

import com.spring.hibernate_demo.entity.Student;
import java.util.List;

/**
 * StudentDao
 * Data Access Object (DAO) interface defining persistence operations 
 * for the {@link Student} entity.
 *
 * @author Felisa Bascug
 */
public interface StudentDao {
    
    /**
     * Persists a new {@link Student} entity into the database.
     *
     * @param theStudent the {@link Student} object to save
     */
    void save(Student theStudent);

    /**
     * Retrieves a {@link Student} by its primary key identifier.
     *
     * @param id the primary key ID of the student
     * @return the {@link Student} entity matching the given ID, 
     *          or {@code null} if not found
     */
    Student findById(Integer id);

    /**
     * Retrieves all {@link Student} entities from the database.
     *
     * @return a {@link List} of all {@link Student} records
     */
    List<Student> findAll();

    /**
     * Retrieves a list of {@link Student} entities matching 
     * the specified last name.
     *
     * @param lastName the last name to search for
     * @return a {@link List} of matching {@link Student} entities
     */
    List<Student> findByLastName(String lastName);

    /**
     * Updates an existing {@link Student} entity in the database.
     *
     * @param theStudent the {@link Student} object containing updated state
     */
    void update(Student theStudent);

    /**
     * Deletes a {@link Student} entity identified by its primary key.
     *
     * @param id the primary key ID of the student to remove
     */
    void delete(Integer id);

    /**
     * Deletes all {@link Student} records from the database table.
     *
     * @return the total number of records deleted
     */
    int deleteAll();

}