package com.edusite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(TeacherInfoId.class)
@Table(name = "tecaher_info")
public class TeacherInfo {

	@Id
	@Column(name = "employeeId")
	private int employeeId;
	
	@Id
	@Column(name = "batch")
	private String batch;
	
	
	@Column(name = "subject_code")
	private int subjectCode;

	public TeacherInfo(int teacherEmployeeId, String batch, int subjectCode) {
		super();
		this.employeeId = teacherEmployeeId;
		this.batch = batch;
		this.subjectCode = subjectCode;
	}

	public TeacherInfo() {
	}

	public int getTeacherEmployeeId() {
		return employeeId;
	}

	public void setTeacherEmployeeId(int teacherEmployeeId) {
		this.employeeId = teacherEmployeeId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	public String toString() {
		return "TeacherInfo [teacherEmployeeId=" + employeeId + ", batch=" + batch + ", subjectCode="
				+ subjectCode + "]";
	}
	
	
	
	
}
