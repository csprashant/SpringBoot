package com.nt.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.exception.StudntNotFoundException;
import com.nt.model.Student;
import com.nt.service.StudentService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
public class StudentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private StudentService studentService;
	
	@Test
	public void  getStudentDetailsTest() throws Exception{
		BDDMockito.given(studentService.getStudentDetails(Mockito.anyString())).willReturn(new Student(1,"Raj",95.24));
		mockMvc.perform(MockMvcRequestBuilders.get("/students/Raj"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isMap())
		.andExpect(jsonPath("name").value("Raj"))
		.andExpect(jsonPath("per").value(95.24));
		
	}
	
	@Test
	public void getStudentDetailsByIDTest() throws Exception{
		Student student = new Student(1,"Raj",95.24);
		BDDMockito.given(studentService.getStudentDetailsById(Mockito.anyInt())).willReturn(student);
		mockMvc.perform(MockMvcRequestBuilders.get("/students/id").param("id", "1"))
		// why param becuase all request mapping in controler class  ("students/{id}") are similer so it confunsed to pick which handler mehtod it should pick so
		//we have go for @RequestParam in the controller class mehtod 
		.andExpect(status().isOk())
		.andExpect(jsonPath("$").isMap())
		.andExpect(jsonPath("name").value("Raj"))
		.andExpect(jsonPath("per").value(95.24));
		
	}
	
	@Test
	public void  StudentNotFoundHttpStatus() throws Exception{
		BDDMockito.given(studentService.getStudentDetails(Mockito.anyString())).willThrow(new StudntNotFoundException());
		mockMvc.perform(MockMvcRequestBuilders.get("/students/Raj"))
		.andExpect(status().isNotFound());
	}
	@Test
	public void updateStudentTest() throws Exception{
		 Student student = new Student(1, "Raj",96.36);
		 student.setName("Raj sinha");
		 BDDMockito.given(studentService.saveOrUpdate(Mockito.any())).willReturn(student);

	        mockMvc.perform(MockMvcRequestBuilders.put("/students/1")
	                .content(new ObjectMapper().writeValueAsString(new Student(1, "Raj",96.36)))
	                .contentType(MediaType.APPLICATION_JSON)
	                .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isCreated())
	                .andExpect(jsonPath("$").isMap())
	                .andDo(print());
	    }
	
	@Test
	public void getAllStudentTest() throws Exception {
			List <Student> listStudent=List.of(new Student(1,"Raj",96.36),
											   new Student(2,"Ramesh",97.36),
											   new Student(3,"Shubash",86.36),
											   new Student(4,"Kuldeep",66.36));
			BDDMockito.given(studentService.getAllRecord()).willReturn(listStudent);
			mockMvc.perform(MockMvcRequestBuilders.get("/students/"))
							.andExpect(status().isOk())
							.andExpect(jsonPath("$").isArray())
							.andDo(print());
		
	}
	@Test
	public void deleteStudentByIdTest() throws Exception{
		BDDMockito.given(studentService.deleteStudentById(Mockito.anyInt())).willReturn("Success");
		mockMvc.perform(MockMvcRequestBuilders.delete("/students/1")
						.contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andDo(print())
						;
						
		
	}
}


	


