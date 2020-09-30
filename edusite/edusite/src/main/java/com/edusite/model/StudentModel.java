package com.edusite.model;

import java.util.List;

import com.edusite.entity.Student;

public class StudentModel {
	
	private int admissionNumber;

	
	private String name;
	
	
	private String fatherName;
	

	private String motherName;
	
	
	private String address;
	
	
	private int year;
	
	
	private String batch;
	
	
	private String role;

	
	private List<Integer> subjectCode;
	
	
	private List<String> subjectName;
	
	
	private List<Integer> employeeId;
	
	


	public StudentModel() {
		//Constructor for model class of Student
	}


	public int getAdmissionNumber() {
		return admissionNumber;
	}


	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFatherName() {
		return fatherName;
	}


	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public List<Integer> getSubjectCode() {
		return subjectCode;
	}


	public void setSubjectCode(List<Integer> subjectCode) {
		this.subjectCode = subjectCode;
	}


	public List<String> getSubjectName() {
		return subjectName;
	}


	public void setSubjectName(List<String> subjectName) {
		this.subjectName = subjectName;
	}


	public List<Integer> getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(List<Integer> employeeId) {
		this.employeeId = employeeId;
	}
	
	public void setsubjectInfo(String subjectName, int subjectCode, int employeeId) {
		this.subjectName.add(subjectName);
		this.subjectCode.add(subjectCode);
		this.employeeId.add(employeeId);
	}
	

	@Override
	public String toString() {
		return "StudentModel [admissionNumber=" + admissionNumber + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", address=" + address + ", year=" + year + ", batch=" + batch
				+ ", role=" + role + ", subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", employeeId="
				+ employeeId + "]";
	}


	public Student converter(StudentModel student) {
		Student studentEntity = new Student();
		
		studentEntity.setAdmissionNumber(student.getAdmissionNumber());
		studentEntity.setName(student.getName());
		studentEntity.setFatherName(student.getFatherName());
		studentEntity.setMothersName(student.getMotherName());
		studentEntity.setAddress(student.getAddress());
		studentEntity.setRole("Student");
		studentEntity.setYear(student.getYear());
		
		return studentEntity;
	}
	
	
	
	
	



































}
