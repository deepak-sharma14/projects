package com.edusite.model;

import java.util.List;

import com.edusite.entity.Student;

public class TeacherModel {

	private int employeeId;
	
	
	private String name;
	
	
	private String address;
	
	
	private String educationQualifications;
	
	
	private String role;
	
		
	private List<Student> students;
	
	
	private String batch;
	
	
	private String subject;


	public TeacherModel() {
//		Constructor for model class of Teacher
	
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEducationQualifications() {
		return educationQualifications;
	}


	public void setEducationQualifications(String educationQualifications) {
		this.educationQualifications = educationQualifications;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public List<Student> getStudent() {
		return students;
	}


	public void setStudent(List<Student> student) {
		this.students = student;
	}


	@Override
	public String toString() {
		return "TeacherModel [employeeId=" + employeeId + ", name=" + name + ", address=" + address
				+ ", educationQualifications=" + educationQualifications + ", role=" + role + ", student=" + students
				+ ", batch=" + batch + ", subject=" + subject + "]";
	}
	
	



	
	
	
	
	
}
