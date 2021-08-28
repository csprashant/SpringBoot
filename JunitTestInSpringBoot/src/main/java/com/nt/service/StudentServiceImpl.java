package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.nt.entity.Student;
import com.nt.exception.StudentNotFoudException;
import com.nt.repo.StudentRepo;
@Component
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepo repo;
	@Override
	public Student saveStudent(Student student) {
		return repo.save(student);
	}
	@Override
	public List<Student> getAllStudent() {
		return repo.findAll();
	}
	@Override
	public Student updateStudent(Integer id,Student student) {
		
		Student existingStudent=getStudentById(id);
		if(existingStudent!=null) {
			
			existingStudent.setName(student.getName());
			existingStudent.setPer(student.getPer());
			return repo.save(existingStudent);
			}
		else
			throw new StudentNotFoudException("student not present");
		}
	@Override
	public String deleteStudent(Integer id) {
		Optional<Student> existingStudent = repo.findById(id);
		if(existingStudent.isPresent()) {
			repo.delete(existingStudent.get());
			return "Record deleted";
		}
		else 
			throw new StudentNotFoudException("Student not found");
	}
	@Override
	public Student getStudentById(Integer id) {
	
		Optional<Student> student = repo.findById(id);
		if(student.isEmpty())
			throw new StudentNotFoudException("Student not found");
			
		else {System.out.println("Foound");
			return student.get();
			
	}}
	
}
