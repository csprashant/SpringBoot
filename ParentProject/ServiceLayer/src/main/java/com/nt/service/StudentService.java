package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudent();

}
