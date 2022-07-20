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
		this.subjectNames.add(subjectName);
	}
	
	public void addTeacherName(String teacherName) {
		teacherNames.add(teacherName);
	}

	@Override
	public String toString() {
		return "GetTeacherAndSubjectNames [admissionNumber=" + admissionNumber + ", subjectNames=" + subjectNames
				+ ", teacherNames=" + teacherNames + "]";
	}
	
	
	
}
