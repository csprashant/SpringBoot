package com.nt.test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.nt.java.PhoneNumberValidator;

public class PhoneNumberValidatorTest {
	
	private PhoneNumberValidator phone;
	@BeforeEach
	public void setUp() {
		phone=new PhoneNumberValidator();
		
	}
	@Test
	public void testForValidPhoneNumber() {
		String phoneNumber="+918871042355";
		boolean isValid=phone.test(phoneNumber);
		assertTrue(isValid);
	}
	
	@Test
	public void testForInvalidPhoneNumbeWithLength() {
		String phoneNumber="+918871042355526352";
		boolean isValid=phone.test(phoneNumber);
		assertFalse(isValid);
	}
	@Test
	public void testForInvalidPhoneNumbeWithCountryCode() {
		String phoneNumber="+558871042355";
		boolean isValid=phone.test(phoneNumber);
		assertFalse(isValid);
	}
	@AfterEach
	public void clear() {
		phone=null;
	}

}
