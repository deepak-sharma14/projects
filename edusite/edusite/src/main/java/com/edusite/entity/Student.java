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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admission_no")
	private int admissionNumber;
	
	@Column(name = "year")
	private int year;

	@Column(name = "role")
	private String role;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id_student") 
	private User user;
	
	//batch object many to many mapped here
	@JsonBackReference
	@ManyToMany(mappedBy = "students")
	private Set<Batch> batches = new HashSet<>();
	
	public Student() {
		/**
		 * Default constructor for Student
		 */
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
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	public Set<Batch> getBatches() {
		return batches;
	}


	public void setBatches(Set<Batch> batches) {
		this.batches = batches;
	}
	
	public void addBatches(Batch batch) {
		if (batch == null) {
			return;
		}
		
		batches.add(batch);
		batch.getStudents().add(this);
	}


	@Override
	public String toString() {
		return "Student [admissionNumber=" + admissionNumber + ", year=" + year + ", role=" + role + ", user=" + user
				+ ", batches=" + batches + "]";
	}

	



	
	

	
	
	
	
}
