package com.nt.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.nt.dao.ILoginDao;
import com.nt.service.ILoginService;
import com.nt.service.LoginServiceImpl;

public class LoginServiceImplTest {
	private static ILoginService service;
	private static ILoginDao daoMock;
	@BeforeAll
	public static void setUpOnce() {
		// for creating mock or dummy oject
		daoMock=Mockito.mock(ILoginDao.class);// mock method will create in memory class implementing IloginDao interface having null method defication having authenticate(-,-)  method
		//crate service class object
		
		service=new LoginServiceImpl(daoMock);
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
	
	
	@AfterAll
	public static void clearAll() {
		service=null;
		daoMock=null;
	}
	
}
