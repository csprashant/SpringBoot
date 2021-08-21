package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@PutMapping("/updateStudent/{id}")
	public String updateStudentById(@PathVariable Integer id,@RequestBody Student student) {
		service.updateStudent(id, student);
		return "Record updated";
	}
	@DeleteMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return service.deleteStudent(id);
}
			
			
		

}
