package com.nt;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.nt.controller.StudentController;
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
	

}
