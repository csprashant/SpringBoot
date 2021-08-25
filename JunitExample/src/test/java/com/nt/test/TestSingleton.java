package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nt.service.Singleton;

public class TestSingleton {
	@Test
	public void TestSingleton(){
		Singleton s1=Singleton.getInstance();
		Singleton s2=Singleton.getInstance();
		//Assertions.assertNotNull(s1);
		//Assertions.assertNotNull(s2);
		if(s1==null || s2==null)
			Assertions.fail("s1 and s2 must not be null");//  if fail() executes after it all statements are skipped
		//Assertions.assertEquals(s1, s2);
		Assertions.assertSame(s1, s2);
		
		
	}

}
