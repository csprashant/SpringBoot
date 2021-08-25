package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import com.nt.service.CensusService;

public class TestCensusService {
	@RepeatedTest(value=10, name="Execution of {displayName}-{currentRepetition} of {totalRepetitions}")
	//here name will display our custom messgsges  at juint console
	public void testExportData(){
		CensusService service=new CensusService();
		Assertions.assertEquals("Data exported", service.exportData());
	}
	@ParameterizedTest
	@ValueSource(ints= {10,11,20,21,30,34})
	
	public void testIsOdd(int n) {
		CensusService service=new CensusService();
		Assertions.assertTrue(service.isOdd(n));
	}
	
	@ParameterizedTest
	@ValueSource(strings= {"Rjesh","Raj"})
	public void testSayMsg(String name) {
		CensusService service=new CensusService();
		Assertions.assertEquals("Hello:"+name,service.sayMsg(name) );
		
	}
	@ParameterizedTest
	//@ValueSource(strings= {"","","K"})
	//@EmptySource  // supply ""
	//@NullSource   // supply null
	@NullAndEmptySource  // one itme null and second time ""
	public void testIsEmpty(String name) {
		CensusService service=new CensusService();
		Assertions.assertTrue(service.isEmpty(name));
	}
}
