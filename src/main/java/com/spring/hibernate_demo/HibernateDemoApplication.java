package com.spring.hibernate_demo;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * HibernateDemoApplication
 * Main Spring Boot application class for executing 
 * Hibernate/JPA CRUD operations.
 * <p>
 * Demonstrates creation, retrieval, updating, and deletion of 
 * {@link Student} entities using a command-line runner bean.
 * </p>
 *
 * @author Felisa Bascug
 */
@SpringBootApplication
public class HibernateDemoApplication {

	/**
	 * Main entry point of the Spring Boot application.
	 *
	 * @param args command-line arguments passed during execution
	 */
	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

	/**
	 * Configures a {@link CommandLineRunner} bean executed upon 
	 * application launch.
	 *
	 * @param studentDao the data access object for performing 
	 * 			{@link Student} CRUD operations
	 * @return a lambda expression containing execution calls 
	 * 		to demonstrate DAO methods
	 */
	@Bean
	CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			createStudent(studentDao);
			// readStudent(studentDao);
			// queryStudents(studentDao);
			// queryStudentLastName(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// deleteAllStudents(studentDao);
		};
	}

	/**
     	* Deletes all student records from the database 
	and logs the number of affected rows.
	*
	* @param studentDao the DAO used to execute bulk deletion
	*/
	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all student information...");
		int rowsDeleted = studentDao.deleteAll();
		System.out.println("Number of deleted rows: " + rowsDeleted);

	}

	/**
	 * Deletes a specific student entity identified 
	 * by hardcoded primary key ID.
	 *
	 * @param studentDao the DAO used to perform deletion
	 */
	private void deleteStudent(StudentDao studentDao) {
		int id = 4;
		System.out.println("Delete ID: " + id);

		// delete student
		studentDao.delete(id);
	}

	/**
	 * Fetches a student by ID, modifies its first name, 
	 * and saves updates to the database.
	 *
	 * @param studentDao the DAO used to fetch and update the entity
	 */
	private void updateStudent(StudentDao studentDao) {
		// retrieve student from id
		int id = 1;
		System.out.println("Student ID: " + id);
		Student student = studentDao.findById(id);

		// change first name
		System.out.println("Updating student name...");
		student.setFirstName("Jawny");

		// update student
		studentDao.update(student);

		// display updated student
		System.out.println("Updated student information: " + student);

	}

	/**
	 * Searches for students matching a specific last name 
	 * and prints the results.
	 *
	 * @param studentDao the DAO used to query entities by last name
	 */
	private void queryStudentLastName(StudentDao studentDao) {
		// get list of students
		List<Student> students = studentDao.findByLastName("Zeppeli");

		//display list of students
		for (Student s : students) {
			System.out.println(s);
		}

	}

	/**
	 * Retrieves all student records stored in the database 
	 * and prints them to the console.
	 *
	 * @param studentDao the DAO used to fetch all entities
	 */
	private void queryStudents(StudentDao studentDao) {
		// get list of students
		List<Student> students = studentDao.findAll();

		// display list of students
		for (Student s : students) {
			System.out.println(s);
		}
	}

	/**
	 * Finds a single student record by primary key ID 
	 * and prints its details.
	 *
	 * @param studentDao the DAO used to look up the student
	 */
	private void readStudent(StudentDao studentDao) {
		// retrieve student from id
		System.out.println("Retrieving student id 2...");
		Student student = studentDao.findById(2);

		// display student
		System.out.println("Found student: " + student);
	}

	/**
	 * Instantiates a new {@link Student} object, 
	 * persists it using the DAO, and logs the generated primary key.
	 *
	 * @param studentDao the DAO used to persist the student
	 */
	private void createStudent(StudentDao studentDao) {
		// create student obj
		System.out.println("Creating student information...");
		Student student = new Student("Josuke",
			"Higashikata",
			"josuke.higashikata@jjba.com");

		// save student obj to database
		System.out.println("Saving student information...");
		studentDao.save(student);

		// display id of saved student
		System.out.println("Saved! Generated id: " + student.getId());
	
	}

}