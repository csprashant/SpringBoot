package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Student;
import com.nt.repo.StudentRepo;
@Service
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
	
}
