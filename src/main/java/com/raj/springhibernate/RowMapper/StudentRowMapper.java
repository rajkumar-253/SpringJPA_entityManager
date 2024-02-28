package com.raj.springhibernate.RowMapper;

import org.springframework.stereotype.Component;

import com.raj.springhibernate.StudentDTO.StudentDTO;
import com.raj.springhibernate.StudentEntity.Student;

@Component
public class StudentRowMapper {
	
	public StudentDTO entityToStudentDTO(Student student) {
		StudentDTO studentDTO=new StudentDTO();
		int id=student.getId();
		studentDTO.setId(id);
		String firstName=student.getFirstName();
		studentDTO.setFirstName(firstName);
		String lastName=student.getLastName();
		studentDTO.setLastName(lastName);
		int age=student.getAge();
		studentDTO.setAge(age);
		String email=student.getEmail();
		studentDTO.setEmail(email);
		return studentDTO;
		
	}
	
	public Student studentDTOtoStudentEntity(StudentDTO studentDTO) {
		Student student=new Student();
		int id=studentDTO.getId();
		student.setId(id);
		String firstName=studentDTO.getFirstName();
		student.setFirstName(firstName);
		String lastName=studentDTO.getLastName();
		student.setLastName(lastName);
		int age=studentDTO.getAge();
		student.setAge(age);
		String email=studentDTO.getEmail();
		student.setEmail(email);
		return student;
	}

}
