package com.raj.springhibernate.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.raj.springhibernate.StudentDTO.StudentDTO;
import com.raj.springhibernate.StudentService.StudentInterface;

@RestController
public class StudenController {
	
	@Autowired
	public StudentInterface studentInterface;
	
	@PostMapping("createStudent")
	public StudentDTO createStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO returnStudent= studentInterface.createStudent(studentDTO);
		return returnStudent;
	}
	@GetMapping("findStudent/{id}")
	public StudentDTO findStudent(@PathVariable int id) {
		return studentInterface.findStudent(id);
		
	}
	
	@GetMapping("getStudents")
	public List<StudentDTO> getAllStudetns() {
		return studentInterface.getAllStudents();
		
	}
	
	@PutMapping("updateStudent")
	public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {
		return studentInterface.updateStudent(studentDTO);
	}
	
	@DeleteMapping("deleteMapping/{id}")
	public void deleteMapping(@PathVariable int id) {
		 studentInterface.deleteStudent(id);
	}

}
