package com.nt.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nt.service.BankService;

public class TestBankService {
private static BankService bankService;

	@BeforeAll
	/* @BeforeAll method must be static */
	public static void initalSetup() {
		bankService = new BankService();
		
	}
	
	/*@BeforeEach
	public void setUp() {
		System.out.println("TestBankService.setUp()");
		bankService=new BankService();
	
	}*/
	@Test
	public void testcalcSimpleInterestAmountWithBigNumber() {
		System.out.println("TestBankService.testcalcSimpleInterestAmountWithBigNumber()");
		float expected=9000.0f;
		float actual=bankService.calcSimpleInterestAmount(150000,3 ,2);
		Assertions.assertEquals(expected,actual);
		
		/*Assertions.assertEquals(exprected,actual,delta,"may be result not matching");
		 here 3rd  is delta which is used to approx calculation so we can give range to correct 
		 here 4rd argument is used to give our choice meassages
		 
		 */
		
	}
	@Test
	public void testcalcSimpleInterestAmountWithSmallNumber() {
		System.out.println("TestBankService.testcalcSimpleInterestAmountWithSmallNumber()");
		float actual=bankService.calcSimpleInterestAmount(150000,3 ,2);
		float expected=9000.12f;
		
		Assertions.assertEquals(expected,actual,0.50);  // 0.50 is delta value means 0.50 is ok  
		
		/* assertequals static method of Assertion class which contains so many method using which we can test
		 * our method in varoius angle */
	}
	@Test
	public void testcalcSimpleInterestAmountWithInvalidArgument() {
		assertThrows(IllegalArgumentException.class,()-> bankService.calcSimpleInterestAmount(0, 0, 0));
		
		/*assertThrows(Class<T>,Executable);
		this method is used to check when the service method some types of execution .
		it takes two arguments first type is type of Exception class and Executable type which is a functional interface which contains single mehtod  which have returntype of Thrawable
		here we can call our mehtod which we want to test 
		assertThrows is used for avoiding error 	*/
		
		/*Error and failure are differnet
		 Error--> exception 
		 failure--> actual result is not equal to expected */
	}

	@Test
	public void testcalcSimpleInterestAmountWithDuration() {
		assertTimeout(Duration.ofMillis(25000), ()->bankService.calcSimpleInterestAmount(23454,2,3));
	}
	/*
	@AfterEach
	public void clear() {
		System.out.println("TestBankService.clear()");
	}
	*/
	
	@AfterAll
	/* @AfterAll method must be static */
	public static void endSetUp() {
		bankService=null;
	}
}
