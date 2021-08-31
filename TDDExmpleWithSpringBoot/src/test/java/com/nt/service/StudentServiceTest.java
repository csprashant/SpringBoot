package com.nt.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nt.exception.StudntNotFoundException;
import com.nt.model.Student;
import com.nt.repo.StudentRepo;

@SpringBootTest
public class StudentServiceTest {
	
	@Autowired
	private StudentService service;
	
	@MockBean
	private StudentRepo repo;
	
	private Student student;
	
	@BeforeEach
	public void setUp() {
		student=new Student(1,"Raj",95.24);	
	}
	
	
	@Test
	public void  testGetStudentDetailsByIdWithException() throws Exception{
		Mockito.when(repo.findById(Mockito.anyInt())).thenThrow(StudntNotFoundException.class);
		assertThrows(StudntNotFoundException.class,()->service.getStudentDetailsById(1));
	}
	
	@Test
	public void testsveStduent() {
		Mockito.when(repo.save(student)).thenReturn(student);
		assertThat(service.saveStudent(student)).isEqualTo(student);
	}
	
	
	
	@Test
	public void testUpdateStudent() {
		Mockito.when(repo.findById(student.getId())).thenReturn(Optional.of(student));
		student.setName("Suman");
		Mockito.when(repo.save(student)).thenReturn(student);
		assertThat(service.updateStudent(1,student)).isEqualTo(student);
	}
	
	@Test
	public void testGetAllRecord() {
		var listStudent=List.of(new Student(1,"Raj",96.36),
								new Student(2,"Ramesh",97.36),
								new Student(3,"Shubash",86.36),
								new Student(4,"Kuldeep",66.36));
		Mockito.when(repo.findAll()).thenReturn(listStudent);
		assertThat(service.getAllRecord()).isEqualTo(listStudent);
	}
	
	@Test
	public void  testGetAllRecordwithException() throws Exception{
		Mockito.when(repo.findAll()).thenThrow(StudntNotFoundException.class);
		assertThrows(StudntNotFoundException.class,()->service.getAllRecord());
	}
	
	
	
	@Test 
	public void testDeleteStudentById() {
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(student));
		Mockito.when(repo.existsById(student.getId())).thenReturn(false);
		assertEquals(service.deleteStudentById(1),"Record deleted");
	}
	
	
	
	
	@Test
	public void testGetStudentDetailsById() {
		Mockito.when(repo.findById(1)).thenReturn(Optional.of(student));
		assertThat(service.getStudentDetailsById(1)).isEqualTo(student);		
	}
	

	@Test
	public void  testGetStudentDetailsByIdwithException() throws Exception{
		Mockito.when(repo.findById(36)).thenThrow(StudntNotFoundException.class);
		assertThrows(StudntNotFoundException.class,()->service.getStudentDetailsById(36));
	}
	
	
	
	
	
	@AfterEach
	public void clear() {
		student=null;
	}
}
