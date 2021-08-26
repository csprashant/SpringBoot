package com.nt.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.nt.entity.Student;
import com.nt.repo.StudentRepo;

@SpringBootTest
public class TestStudentServiceImpl{
	@Autowired
	private StudentService service;
	@MockBean
	private StudentRepo repo;
	
	@Test
	public void testSaveStudent() {
		Student student = new Student(1,"Raj",85.25f);
		Mockito.when(repo.save(student)).thenReturn(student);
		assertThat(service.saveStudent(student)).isEqualTo(student);
	}
	@Test
	public void testGetAllStudent() {
		Student student1 = new Student(1,"Raj",85.25f);
		Student student2 = new Student(2,"Rahul",65.25f);
		Student student3 = new Student(3,"Suman",55.25f);
		List studdentList=List.of(student1,student2,student3);
		Mockito.when(repo.findAll()).thenReturn(studdentList);
		assertThat(service.getAllStudent()).isEqualTo(studdentList);
	}
	@Test
	public void testUpdateStudent() {
		Student student1 = new Student(1,"Raj",85.25f);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(student1));
		student1.setName("Raj Verma");
		Mockito.when(repo.save(student1)).thenReturn(student1);
		assertThat(service.updateStudent(1, student1)).isEqualTo(student1);
	}
	
	@Test
	public void testDeleteStudent() {
		Student student1 = new Student(1,"Raj",85.25f);
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(student1));
		Mockito.when(repo.existsById(student1.getId())).thenReturn(false);
		assertEquals(service.deleteStudent(1),"Record deleted");
	}

}
