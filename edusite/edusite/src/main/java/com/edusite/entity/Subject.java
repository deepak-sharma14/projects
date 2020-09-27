package com.edusite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SubjectId.class)
@Table(name = "subject")
public class Subject {

	@Id
	@Column(name = "AdmissionNumber")
	private int admissionNumber;
	
	@Column(name = 	"Subject")
	private String subjectName;
	
	@Id
	@Column(name = "Subject_code")
	private int subjectCode;
	
	@Column(name = "EmployeeId")
	private int employeeId;


	public Subject() {
//		Constructor of the class Subject
	}


	public int getAdmissionNumber() {
		return admissionNumber;
	}


	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}


	public String getSubject() {
		return subjectName;
	}


	public void setSubject(String subject) {
		this.subjectName = subject;
	}


	public int getSubjectCode() {
		return subjectCode;
	}


	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	@Override
	public String toString() {
		return "Subject [admissionNumber=" + admissionNumber + ", subject=" + subjectName + ", subjectCode=" + subjectCode
				+ ", employeeId=" + employeeId + "]";
	}
	
	
	
	
	
}
