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
    
    void save(Student theStudent);    
    Student findById(Integer id);    
    List<Student> findAll();    
    List<Student> findByLastName(String lastName);    
    void update(Student theStudent);    
    void delete(Integer id);    
    int deleteAll();

}