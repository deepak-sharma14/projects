package com.edusite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "educational_qualification")
	private String educationQualifications;
	
	@Column(name = "role")
	private String role;

	
	/**
	 *teacher->Batches->Students
	 *new table of teacher and batch,column of batch in student table
	 *		
	 */
//	

	public Teacher() {

	}


	public Teacher(int employeeId, String name, String address) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
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

	@Override
	public String toString() {
		return "Teacher [employeeId=" + employeeId + ", name=" + name + ", address=" + address
				+ ", educationQualifications=" + educationQualifications + "]";
	}

	
	
	
	
	
	
	
	
	
	
}
