package com.raj.springhibernate.StudentREPO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.raj.springhibernate.RowMapper.StudentRowMapper;
import com.raj.springhibernate.StudentDTO.StudentDTO;
import com.raj.springhibernate.StudentEntity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class StudentRepository {
	
	@Autowired
	public EntityManager entityManager;
	@Autowired
	public StudentRowMapper studentRowMapper;
	
	
	public StudentDTO createStudent(StudentDTO studentDTO) {
		Student student=studentRowMapper.studentDTOtoStudentEntity(studentDTO);
		entityManager.persist(student);
		StudentDTO studentReturn= studentRowMapper.entityToStudentDTO(student);
		return studentReturn;
	}
	
	public StudentDTO findStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		return studentRowMapper.entityToStudentDTO(student);
	}
	
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		int id=studentDTO.getId();	
		
		StudentDTO existingStudent=findStudent(id);
		Student student=studentRowMapper.studentDTOtoStudentEntity(existingStudent);
		if(student!=null) {
			student.setFirstName(studentDTO.getFirstName());
			student.setLastName(studentDTO.getLastName());
			student.setAge(studentDTO.getAge());
			student.setEmail(studentDTO.getEmail());
			entityManager.merge(student);
			return studentRowMapper.entityToStudentDTO(student);
		}
		return null;
		
	}
	public void deleteStudent(int id) {
		StudentDTO deleteStudent=findStudent(id);
		Student studentDelete=studentRowMapper.studentDTOtoStudentEntity(deleteStudent);
		if(studentDelete!=null) {
			entityManager.remove(studentDelete);
		}
	}
	
	public List<StudentDTO> getAllStudents(){
		List<Student> query = entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
		Iterator<Student> students=query.iterator();
		List<StudentDTO> studentDTO=new ArrayList<>();
		while(students.hasNext()) {
			Student student=students.next();
			StudentDTO studentDTO1=studentRowMapper.entityToStudentDTO(student);
			studentDTO.add(studentDTO1);
		}
		
		return studentDTO;
		
	}

}
