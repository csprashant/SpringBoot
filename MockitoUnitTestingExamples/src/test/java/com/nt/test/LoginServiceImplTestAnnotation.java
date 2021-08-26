package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.nt.dao.ILoginDao;
import com.nt.service.LoginServiceImpl;

public class LoginServiceImplTestAnnotation {
	@InjectMocks
	private LoginServiceImpl service;
	@Mock
	private ILoginDao daoMock;
	public LoginServiceImplTestAnnotation() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void loginWithValidCredentials() {
		// provding stub functionality   for dao aunthenticate method
		Mockito.when(daoMock.auntheticate("abc","123" )).thenReturn(1);
		// unit test code
		Assertions.assertTrue(service.Login("abc", "123"));
	}
	@Test
	public void loginWithInvalidCredentials() {
		// provding stub functionality  for dao aunthenticate method
		Mockito.when(daoMock.auntheticate("abc","123" )).thenReturn(0);
		// unit test code
		Assertions.assertFalse(service.Login("Raj", "123"));
	}
	@Test
	public void loginWithNoCredentials() {
	Assertions.assertThrows(IllegalArgumentException.class,()->service.Login("",""));
	}
	
}
