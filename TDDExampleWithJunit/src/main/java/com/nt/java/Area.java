package com.nt.java;

public class Area {
	public Double calcCircleArea(float r) {
		if(r==0)
			throw new IllegalArgumentException();
		return (3.14*r*r);
	}
}
