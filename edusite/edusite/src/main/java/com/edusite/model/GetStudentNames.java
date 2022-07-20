package com.edusite.model;

import java.util.ArrayList;
import java.util.List;

public class GetStudentNames {

	private List<String> studentNames =  new ArrayList<>();

	public GetStudentNames() {
		/*
		 * Constructor for this class
		 */
	}

	public List<String> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}

	public void addStudentNames(String studentName) {
		System.out.println("Student name is " + studentName);
		this.studentNames.add(studentName);
	}
	
}
