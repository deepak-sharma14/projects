package com.edusite.model;

import java.sql.Date;
import java.util.List;

import com.edusite.entity.Student;
import com.edusite.entity.User;

public class StudentModel {
	
	private int admissionNumber;

	private String address;
	
	private String name;
	
	private String fatherName;
	
	private String motherName;
	
	private int year;
	
	private String batch;
	
	private String role;

	private int userId;
	
	private Date dob;
	
	private String loginId;
	
	private String password;
	
	private int batchId;
	
	private List<String> subjectCodes;
	
	private List<String> subjectNames;
	
	private List<String> teacherNames;
	

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

	

	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getBatchId() {
		return batchId;
	}


	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}


	public List<String> getSubjectCode() {
		return subjectCodes;
	}


	public void setSubjectCode(List<String> subjectCode) {
		this.subjectCodes = subjectCode;
	}


	public List<String> getSubjectName() {
		return subjectNames;
	}


	public void setSubjectName(List<String> subjectName) {
		this.subjectNames = subjectName;
	}

	public void addSubjectName(String subjectName) {
		this.subjectNames.add(subjectName);
	}
	
	public List<String> getTeacherNames() {
		return teacherNames;
	}

	public void setTeacherNames(List<String> teacherNames) {
		this.teacherNames = teacherNames;
	}
	
	public void addTeacherName(String teacherName) {
		this.teacherNames.add(teacherName);
	}

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	

	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public void setsubjectInfo(String subjectName, String subjectCode) {
		this.subjectNames.add(subjectName);
		this.subjectCodes.add(subjectCode);
	}
	

	

	@Override
	public String toString() {
		return "StudentModel [admissionNumber=" + admissionNumber + ", name=" + name + ", fatherName=" + fatherName
				+ ", motherName=" + motherName + ", address=" + address + ", year=" + year + ", batch=" + batch
				+ ", role=" + role + ", userId=" + userId + ", dob=" + dob + ", loginId=" + loginId + ", password="
				+ password + ", subjectCode=" + subjectCodes + ", subjectName=" + subjectNames + ", teacherNames="
				+ teacherNames + "]";
	}


	public Student studentConverter(StudentModel student) {
		Student studentEntity = new Student();
		
		studentEntity.setAdmissionNumber(student.getAdmissionNumber());
		
		studentEntity.setRole("Student");
		studentEntity.setYear(student.getYear());
	
		
		
		return studentEntity;
	}
	
	public User userConverter(StudentModel student) {
		User user = new User();
		user.setUserId(student.getUserId());
		user.setName(student.getName());
		user.setFatherName(student.getFatherName());
		user.setMotherName(student.getMotherName());
		user.setAddress(student.getAddress());
		user.setDob(student.getDob());
		user.setLoginId(student.getLoginId());
		user.setPassword(student.getPassword());
		
		return user;
		
	}
	
	
	
	



































}
