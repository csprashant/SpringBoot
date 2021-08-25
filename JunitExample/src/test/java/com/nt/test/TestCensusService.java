package com.nt.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.nt.service.CensusService;

public class TestCensusService {
	@RepeatedTest(value=10, name="Execution of {displayName}-{currentRepetition} of {totalRepetitions}")
	//here name will display our custom messgsges  at juint console
	public void TestExportData(){
		CensusService service=new CensusService();
		Assertions.assertEquals("Data exported", service.exportData());
	}
	

}
