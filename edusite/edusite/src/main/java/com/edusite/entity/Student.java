package com.edusite.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admissionNo")
	private int admissionNumber;
	
	@Column(name = "year")
	private int year;

	@Column(name = "role")
	private String role;
	
	//batch
	@Column(name = "batch")
	private String batch;
	
	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@OneToMany(mappedBy = "admissionNo", cascade = CascadeType.ALL)
	List<Subject> subject;  

	public Student() {

	
	}


	public int getAdmissionNumber() {
		return admissionNumber;
	}


	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Student [admissionNumber=" + admissionNumber + ", year=" + year
				+ ", role=" + role + "]";
	}
	
	
	

	
	
	
	
}
