package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
		Student student=studentService.getStudentDetails(name);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
}
