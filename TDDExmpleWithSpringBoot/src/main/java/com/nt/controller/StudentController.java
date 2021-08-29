package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;
import com.nt.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/{name}")
	public ResponseEntity<Student> getStudentDetails(@PathVariable String name) throws Exception{
		return new ResponseEntity<>(studentService.getStudentDetails(name),HttpStatus.OK);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Student> getStudentDetailsById(@RequestParam Integer id) throws Exception{
		return new ResponseEntity<>(studentService.getStudentDetailsById(id),HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable Integer id,  @RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveOrUpdate(student),HttpStatus.CREATED);
	}
	
}
