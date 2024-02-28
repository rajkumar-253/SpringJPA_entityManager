package com.raj.springhibernate.StudentService;

import java.util.List;

import com.raj.springhibernate.StudentDTO.StudentDTO;

public interface StudentInterface {
	
	public StudentDTO createStudent(StudentDTO studentDTO);
	public StudentDTO findStudent(int id);
	public void deleteStudent(int id);
	public StudentDTO updateStudent(StudentDTO studentDTO);
	public List<StudentDTO> getAllStudents();

}
