package com.nt.repo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.nt.model.Student;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
public class TestStudentRepo {
	
	@Autowired
	private StudentRepo repo;
	@Test
	public  void testSaveStduent() {
		Student saveStudent = repo.save(new Student(1,"Raj",96.36));
        Optional<Student> returnstudent = Optional.of(repo.findByName("Raj"));
        assertTrue(returnstudent.isPresent());
        assertEquals(saveStudent,returnstudent.get());
	}
	@Test
	public void testGetAllStudent() {
		List<Student> listStudent=repo.findAll();
		assertTrue(listStudent.isEmpty());
		assertEquals(listStudent.size(), 4);	
	}
	
	@Test
	public void testUpdateCar() {
		 Optional<Student> toBeUpdatedStudent = Optional.of(repo.findByName("Raj"));
		 System.out.println(toBeUpdatedStudent);
	        toBeUpdatedStudent.get().setPer(100.00);
	        repo.save(toBeUpdatedStudent.get());
	        Optional<Student> updateStudent = Optional.of(repo.findByName("Raj"));
	        assertEquals(100.00,updateStudent.get().getPer());
	
	}
	
	

}
