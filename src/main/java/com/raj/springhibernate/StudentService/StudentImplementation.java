package com.raj.springhibernate.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.springhibernate.StudentDTO.StudentDTO;
import com.raj.springhibernate.StudentREPO.StudentRepository;

@Service
public class StudentImplementation implements StudentInterface {
	
	@Autowired
	public StudentRepository studentRepository;

	@Override
	public StudentDTO createStudent(StudentDTO studentDTO) {
		StudentDTO returnStudent=studentRepository.createStudent(studentDTO);
		return returnStudent;
		
	}

	@Override
	public StudentDTO findStudent(int id) {
		return studentRepository.findStudent(id);
	}

	

	@Override
	public StudentDTO updateStudent(StudentDTO studentDTO) {
		return studentRepository.updateStudent(studentDTO);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		return studentRepository.getAllStudents();
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteStudent(id);
		
	}

}
