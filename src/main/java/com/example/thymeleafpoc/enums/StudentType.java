package com.example.thymeleafpoc.enums;


public enum StudentType {
	
	ELEMENTARY("Elementary"),
	HIGH_SCHOOL("High School"),
	UNIVERSITY("University");
	
	private String name;
	
	StudentType(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}

}
