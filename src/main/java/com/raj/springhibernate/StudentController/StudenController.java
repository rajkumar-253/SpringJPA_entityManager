package com.raj.springhibernate.StudentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
		StudentDTO returnStudent= studentInterface.createStudent(studentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(returnStudent);
	}
	@GetMapping("findStudent/{id}")
	public ResponseEntity<StudentDTO> findStudent(@PathVariable int id) {
		 StudentDTO student = studentInterface.findStudent(id);
		 return ResponseEntity.ok().body(student);
		
	}
	
	@GetMapping("getStudents")
	public ResponseEntity<List<StudentDTO>> getAllStudetns() {
		 List<StudentDTO> allStudents = studentInterface.getAllStudents();
		 return ResponseEntity.ok(allStudents);
		
	}
	
	@PutMapping("updateStudent")
	public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO) {
		 StudentDTO updateStudent = studentInterface.updateStudent(studentDTO);
		 return ResponseEntity.status(HttpStatus.OK).body(updateStudent);
	}
	
	@DeleteMapping("deleteStudent/{id}")
	public ResponseEntity<String> deleteMapping(@PathVariable int id) {
		 studentInterface.deleteStudent(id);
		 return ResponseEntity.ok().body("Successfully Deleted");
	}

}
