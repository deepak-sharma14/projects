package com.edusite.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admissionNumber")
	private int admissionNumber;
	
	@Column(name = "name")
	private String name;
		
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String mothersName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "year")
	private int year;

	@Column(name = "role")
	private String role;
	
	//batch
	@Column(name = "batch")
	private String batch;

	public Student() {

	
	}


	public Student(int admissionNumber, String name, String fatherName, String mothersName,
			String address, List<String> subjects) {
		this.admissionNumber = admissionNumber;
		this.name = name;
		this.fatherName = fatherName;
		this.mothersName = mothersName;
		this.address = address;
	}


	


	public int getAdmissionNumber() {
		return admissionNumber;
	}


	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
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


	public String getMothersName() {
		return mothersName;
	}


	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getName() {
		return name;
	}


	@Override
	public String toString() {
		return "Student [admissionNumber=" + admissionNumber + ", name=" + name + ", fatherName=" + fatherName
				+ ", mothersName=" + mothersName + ", address=" + address + ", year=" + year
				+ ", role=" + role + "]";
	}
	
	
	

	
	
	
	
}
