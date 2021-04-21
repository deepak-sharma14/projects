package com.edusite.model;

import java.util.ArrayList;
import java.util.List;

public class GetTeacherAndSubjectNames {
	
	private int admissionNumber;

	private List<String> subjectNames = new ArrayList<>();
	
	private List<String> teacherNames = new ArrayList<>();

	public GetTeacherAndSubjectNames() {
	}
	
	public int getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public List<String> getSubjectNames() {
		return subjectNames;
	}

	public void setSubjectNames(List<String> subjectNames) {
		this.subjectNames = subjectNames;
	}

	public List<String> getTeacherNames() {
		return teacherNames;
	}

	public void setTeacherNames(List<String> teacherNames) {
		this.teacherNames = teacherNames;
	}
	
	public void addSubjectName(String subjectName) {
//		System.out.println("Inside addSubjectNames");
		this.subjectNames.add(subjectName);
	}
	
	public void addTeacherName(String teacherName) {
//		System.out.println("Inside addTeacherNames"+ teacherName);
//		System.out.println(" TeacherNames "+ teacherNames);
		teacherNames.add(teacherName);
//		System.out.println("Added teacher name");
	}

	@Override
	public String toString() {
		return "GetTeacherAndSubjectNames [admissionNumber=" + admissionNumber + ", subjectNames=" + subjectNames
				+ ", teacherNames=" + teacherNames + "]";
	}
	
	
	
}
