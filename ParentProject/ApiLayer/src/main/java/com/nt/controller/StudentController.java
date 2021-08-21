package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Student;
import com.nt.service.StudentService;
@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	@PostMapping("/saveStudent")
	public Student saveRecord(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	@GetMapping("/getStudents")
	public List<Student> getAllStudentInfo(){
		return service.getAllStudent();
	}
	
		

}
