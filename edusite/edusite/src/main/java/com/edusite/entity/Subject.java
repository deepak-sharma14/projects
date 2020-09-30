package com.edusite.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(SubjectId.class)
@Table(name = "student_teacher_syllabus")
public class Subject {

//	@Id
//	@Column(name = "admissionNo")
//	private int admissionNumber;
//	
//	
//	@Id
//	@Column(name = "Subject_code")
//	private int subjectCode;
//	
//	@Column(name = "EmployeeId")
//	private int employeeId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "admissionNo")
	private Student student;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employeeId")
	private Teacher teacher;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "subjectCode")
	private Syllabus syllabus ;
	
	
	public Subject() {
//		Constructor of the class Subject
	}

	
	
	
	
}
