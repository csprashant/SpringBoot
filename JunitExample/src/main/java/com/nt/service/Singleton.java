package com.nt.service;

public class Singleton {
	private static Singleton INSTANCE;
	private Singleton() {	
	}
	public static Singleton getInstance() {
		return INSTANCE;
	}
	

}
