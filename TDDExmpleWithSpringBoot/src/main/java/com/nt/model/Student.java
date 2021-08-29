package com.nt.model;

public class Student {
	private Integer Id;
	private String name;
	private Double per;
	public Student() {
	}
	public Student(Integer id, String name, Double per) {
		super();
		Id = id;
		this.name = name;
		this.per = per;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPer() {
		return per;
	}
	public void setPer(Double per) {
		this.per = per;
	}
	
	

}
