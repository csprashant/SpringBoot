package com.nt.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	public Student findByName(String name);
}
