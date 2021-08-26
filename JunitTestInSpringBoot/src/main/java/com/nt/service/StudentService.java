package com.nt.service;

import java.util.List;

import com.nt.entity.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student updateStudent(Integer id,Student student);
	public String deleteStudent(Integer id);
	public Student getStudentById(Integer id);
}
