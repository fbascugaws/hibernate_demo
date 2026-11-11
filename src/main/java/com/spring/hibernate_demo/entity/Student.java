package com.spring.hibernate_demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Student
 * Represents a Student entity mapped to the database table {@code student}.
 * <p>
 * This class uses JPA annotations to map its fields to corresponding columns 
 * in the underlying relational database table.
 * </p>
 *
 * @author Felisa Bascug
 */
@Entity
@Table (name = "student")
public class Student {

    /**
     * Unique identifier for the student.
     * Auto-generated using the database identity column strategy.
     */
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;

    /**
     * First name of the student.
     */
    @Column (name = "first_name")
    private String firstName;

    /**
     * Last name of the student.
     */
    @Column (name = "last_name")
    private String lastName;

    /**
     * Email address of the student.
     */
    @Column (name = "email")
    private String email;

    /**
     * Default no-argument constructor required by Hibernate/JPA.
     */
    public Student() {
    }

    /**
     * Constructs a new {@code Student} with the specified first name, 
     * last name, and email.
     *
     * @param firstName the first name of the student
     * @param lastName  the last name of the student
     * @param email     the email address of the student
     */
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Gets the student's ID.
     *
     * @return the unique ID of the student
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the student's ID.
     *
     * @param id the unique ID to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the first name of the student.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the student.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the student.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the student.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the email address of the student.
     *
     * @return the email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the student.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns a string representation of the {@code Student} object.
     *
     * @return a formatted string containing student details 
     * (id, firstName, lastName, email)
     */
    @Override
    public String toString() {
        return "Student [id=" + id 
                    + ", firstName=" + firstName 
                    + ", lastName=" + lastName 
                    + ", email=" + email + "]";
    }
    
}