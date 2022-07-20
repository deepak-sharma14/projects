package com.edusite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name ="teacher")
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private int employeeId;
	 
	@Column(name = "educational_qualification")
	private String educationQualifications;
	
	@Column(name = "role")
	private String role;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id")
	private User userTeacher;
	
	//One to Many here(One teacher multiple batch id)
	@JsonManagedReference
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
	private Set<Batch> batches = new HashSet<>();
		
	public Teacher() {

	}


	public Teacher(int employeeId) {
		super();
		this.employeeId = employeeId;
	}	
			


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	

	public User getUser() {
		return userTeacher;
	}


	public void setUser(User user) {
		this.userTeacher = user;
	}

	public void setUserTeacher(User userTeacher) {
		this.userTeacher = userTeacher;
	}


	public Set<Batch> getBatches() {
		return batches;
	}
	
	public void addBatches(Batch batch) {
		if(batch == null)
			return;
		
		this.batches.add(batch);
		batch.setTeacher(this);
	}

	@Override
	public String toString() {
		return "Teacher [employeeId=" + employeeId + ", educationQualifications=" + educationQualifications + ", role="
				+ role ;
	}


	
	
	
	
	
	
	
	
	
	
	
}
