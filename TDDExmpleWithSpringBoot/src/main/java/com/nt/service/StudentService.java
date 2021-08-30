package com.nt.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.StudntNotFoundException;
import com.nt.model.Student;
import com.nt.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	public Student getStudentDetailsByName(String name) {
		Student student=repo.findByName(name);
		if(student==null)
			throw new StudntNotFoundException();
		else
			return student;
	}

	public Student updateStudent(Integer id,Student student) {
		Optional<Student> existingStudent=repo.findById(id);
		if(existingStudent.isPresent()) {
			existingStudent.get().setName(student.getName());
			existingStudent.get().setPer(student.getPer());
			return repo.save(existingStudent.get());
			}
			
		else
			 throw new StudntNotFoundException();
	}
	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public Student getStudentDetailsById(Integer i) {
		
		return null;
	}

	public List<Student> getAllRecord() {
		
		return null;
	}

	public String deleteStudentById(int id) {
		
		return null;
	}
	
	

}
