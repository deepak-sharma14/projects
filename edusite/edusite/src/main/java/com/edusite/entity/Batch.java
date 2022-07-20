package com.edusite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "batch_id")
	private int batchId;
	
	@JoinColumn(name = "batch_name")
	private String batchName;

	//One to many(batches)
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "syllabus_id", nullable = false)
	private Syllabus syllabus;
	
	//One employee id to multiple batch id
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", nullable = false)
	private Teacher teacher;
	
	//Many to Many mapping between students and batches
	@JsonManagedReference
	@ManyToMany()
	@JoinTable(
			name = "Student_Batch",
			joinColumns = @JoinColumn(name = "batch_id"),
			inverseJoinColumns = @JoinColumn(name = "student_admission_no"))
	private Set<Student> students = new HashSet<>();
	
	//NOTE-
	//In batch_student table there is many to many linking between the tables.
	
	
	public Batch( String batch) {
		super();
		this.batchName = batch;
	}

	public Batch() {
	}

	
	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Syllabus getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(Syllabus syllabus) {
		this.syllabus = syllabus;
	}

	public void setBatch(String batch) {
		this.batchName = batch;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public void addStudents(Student student) {
		students.add(student);
		student.getBatches().add(this);
	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", syllabus=" + syllabus + ", teacher="
				+ teacher + ", students=" + students + "]";
	}
	
	
	
	 

	
	
	
	
}
