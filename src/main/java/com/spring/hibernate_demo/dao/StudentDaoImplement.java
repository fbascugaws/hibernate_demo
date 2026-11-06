package com.spring.hibernate_demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.hibernate_demo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

@Repository // specialized @Component annotation for dB communication
public class StudentDaoImplement implements StudentDao {

    // define field for entity manager
    private EntityManager em;

    // constructor injection
    public StudentDaoImplement(EntityManager em) {
        this.em = em;
    }

    // save method
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