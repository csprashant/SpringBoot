package com.nt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	@PostMapping("/student")
	public ResponseEntity<Student> saveRecord(@RequestBody Student student) {
		Student savedStudent=service.saveStudent(student);
		if(savedStudent==null)
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		return new ResponseEntity<Student>( savedStudent,HttpStatus.CREATED);
	}
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentInfo(){
		List<Student> listStudents= service.getAllStudent();
		if(listStudents.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(listStudents));
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Integer id){
		Student student=service.getStudentById(id);
		if(student!=null)
			return new ResponseEntity<Student>(student,HttpStatus.FOUND);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable Integer id,@RequestBody Student student) {
		System.out.println("StudentController.updateStudentById()");
		try{
			Student updatedStudent = service.updateStudent(id, student);
			System.out.println("done");
			return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
			}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}	
	}
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
		try{
			service.deleteStudent(id);
			return ResponseEntity.ok().build();
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}	

}
