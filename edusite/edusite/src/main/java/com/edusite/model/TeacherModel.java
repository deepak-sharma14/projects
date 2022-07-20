package com.edusite.model;

import java.sql.Date;
import java.util.List;

import com.edusite.entity.Student;
import com.edusite.entity.Teacher;
import com.edusite.entity.User;

public class TeacherModel {

	private int employeeId;
	
	private String name;
	
	private String address;
	
	private String educationQualifications;
	
	private String role;
	
	private String fatherName;
	
	private String motherName;
		
	private List<Student> students;
	
	private String batch;
	
	private String subject;

	private int userId;
	
	private Date dob;
	
	private String loginId;
	
	private String password;

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
	
	


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
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
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
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


	@Override
	public String toString() {
		return "TeacherModel [employeeId=" + employeeId + ", name=" + name + ", address=" + address
				+ ", educationQualifications=" + educationQualifications + ", role=" + role + ", student=" + students
				+ ", batch=" + batch + ", subject=" + subject + "]";
	}


	public Teacher teacherConverter(TeacherModel teacher) {
		Teacher teacherEntity = new Teacher();
		
		teacherEntity .setEmployeeId(teacher.getEmployeeId());
		teacherEntity.setEducationQualifications(teacher.getEducationQualifications());
		teacherEntity.setUser(this.userConverter(teacher));
		teacherEntity .setRole("Teacher");
		return teacherEntity ;
	}


	public User userConverter(TeacherModel teacher) {
		User user = new User();
		user.setUserId(teacher.getUserId());
		user.setName(teacher.getName());
		user.setFatherName(teacher.getFatherName());
		user.setMotherName(teacher.getMotherName());
		user.setAddress(teacher.getAddress());
		user.setDob(teacher.getDob());
		user.setLoginId(teacher.getLoginId());
		user.setPassword(teacher.getPassword());
		
		return user;
	}
	
	



	
	
	
	
	
}
