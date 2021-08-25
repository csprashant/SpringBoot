package com.nt.service;

public class CensusService {
	public String exportData() {
		return "Data exported";
	}
	public boolean isOdd(int n) {
		if (n%2==0)
			return false;
		else
			return true;
	}
	public String  sayMsg(String name) {
		return "Hello:"+name;
	}
	
	public boolean isEmpty(String name) {
		return name.isBlank();
	}
}
