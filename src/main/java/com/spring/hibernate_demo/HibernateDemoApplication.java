package com.spring.hibernate_demo;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.hibernate_demo.dao.StudentDao;
import com.spring.hibernate_demo.entity.Student;

@SpringBootApplication
public class HibernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernateDemoApplication.class, args);
	}

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

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all student information...");
		int rowsDeleted = studentDao.deleteAll();
		System.out.println("Number of deleted rows: " + rowsDeleted);

	}

	private void deleteStudent(StudentDao studentDao) {
		int id = 4;
		System.out.println("Delete ID: " + id);

		// delete student
		studentDao.delete(id);
	}

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

	private void queryStudentLastName(StudentDao studentDao) {
		// get list of students
		List<Student> students = studentDao.findByLastName("Zeppeli");

		//display list of students
		for (Student s : students) {
			System.out.println(s);
		}

	}

	private void queryStudents(StudentDao studentDao) {
		// get list of students
		List<Student> students = studentDao.findAll();

		// display list of students
		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void readStudent(StudentDao studentDao) {
		// retrieve student from id
		System.out.println("Retrieving student id 2...");
		Student student = studentDao.findById(2);

		// display student
		System.out.println("Found student: " + student);
	}

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