package com.edusite.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@OneToOne
	@JoinColumn(name = "userId")
	private User user;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "",
			joinColumns = @JoinColumn(name = "empployeeId"),
			inverseJoinColumns = @JoinColumn(name = "batch" ))
	private Set<Batch> batch;
	
	/**
	 *teacher->Batches->Students
	 *new table of teacher and batch,column of batch in student table
	 *		
	 */
//	

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
	
	

	public User getUserId() {
		return user;
	}


	public void setUserId(User userId) {
		this.user = userId;
	}


	@Override
	public String toString() {
		return "Teacher [employeeId=" + employeeId + ", educationQualifications=" + educationQualifications + ", role="
				+ role + ", userId=" + user + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
}
