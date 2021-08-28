package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.nt.java.Area;

public class AreaTest {
	@Test
	public void testCalcCircleArea(){
		Area area=new Area();
		Assertions.assertEquals(314, area.calcCircleArea(10));	
	}
	@Test
	public void testCalcCircleAreaWithInvalidInput(){
		Area area=new Area();
		Assertions.assertThrows(IllegalArgumentException.class,()->area.calcCircleArea(0));
	}
	
}
