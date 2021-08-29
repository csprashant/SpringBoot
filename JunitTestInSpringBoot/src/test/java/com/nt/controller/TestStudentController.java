package com.nt.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Student;
import com.nt.repo.StudentRepo;
import com.nt.service.StudentServiceImpl;

@WebMvcTest(StudentController.class)
//@SpringBootTest
public class TestStudentController {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private StudentServiceImpl service;
	@MockBean
	private StudentRepo repo;
	@Test
	public void testSaveRecord() throws Exception {
		Student student = new Student(1,"Raj",85.25f);
		String inputInJson=this.mapToJson(student);
		Mockito.when(service.saveStudent(Mockito.any(Student.class))).thenReturn(student);
		RequestBuilder builder=MockMvcRequestBuilders.post("/student")
							   .accept(MediaType.APPLICATION_JSON)
							   .content(inputInJson)
							   .contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputInJson = response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	}
	
	@Test
	public void testGetAllStudentInfo() throws Exception {
		Student student1 = new Student(1,"Raj",85.25f);
		Student student2 = new Student(2,"Rahul",75.25f);
		Student student3= new Student(3,"Shri",95.25f);
		List<Student> studentList=List.of(student1,student2,student3);
		
		String inputInJson=this.mapToJson(studentList);
		Mockito.when(service.getAllStudent()).thenReturn(studentList);
		
		RequestBuilder builder=MockMvcRequestBuilders.get("/students").
								accept(MediaType.APPLICATION_JSON).content(inputInJson)
								.contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result=mockMvc.perform(builder).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		String outputInJson=response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());	
	}
	
	@Test
	public void testUpdateStudentById() throws Exception{
		Student student1 = new Student(1,"Raj",85.25f);
		System.out.println("Going to getStudentByIdMethod");
		Mockito.when(service.getStudentById(1)).thenReturn(student1);
		System.out.println("Student Retrived");
		student1.setName("Shiva soni");
		
		Mockito.when(service.updateStudent(1, student1)).thenReturn(student1);
		System.out.println("Student updated");
		String inputInJson=this.mapToJson(student1);
				
		RequestBuilder builder=MockMvcRequestBuilders.put("/student/1").
				accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		System.out.println("Request builder created");
		MvcResult result=mockMvc.perform(builder).andReturn();
		System.out.println("Result generated");
		MockHttpServletResponse response=result.getResponse();
		System.out.println("response generated");
		String outputInJson=response.getContentAsString();
		assertThat(outputInJson).isEqualTo(inputInJson);
		assertEquals(HttpStatus.OK.value(),response.getStatus());	
	
	}
	/*@Test
	public void testDeleteStudent() throws Exception
	{
		Student student1 = new Student(1,"Raj",85.25f);
		Mockito.when(service.getStudentById(1)).thenReturn(student1);
		String inputInJson=this.mapToJson(student1);
		System.out.println(inputInJson);
		Mockito.when(service.deleteStudent(1)).thenReturn("Record deleted");
		RequestBuilder builder=MockMvcRequestBuilders.delete("/student/1").
				accept(MediaType.APPLICATION_JSON).content(inputInJson)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result=mockMvc.perform(builder).andReturn();
		MockHttpServletResponse response=result.getResponse();
		String outputInJson=response.getContentAsString();
		assertThat(outputInJson).isEqualTo("Record deleted");
		assertEquals(HttpStatus.OK.value(),response.getStatus());	
		
	}
	*/
	
	
	public String mapToJson(Object obj) throws JsonProcessingException{
		ObjectMapper mapper=new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	

}
