package com.edusite.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "batch")
public class Batch {

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "",
			joinColumns = @JoinColumn(name = "batch"),
			inverseJoinColumns = @JoinColumn(name = "employeeId" ))
	private Set<Teacher> teacher;
	
	@Id
	@Column(name = "batch")
	private String batch;
	
	public Batch(int teacherEmployeeId, String batch) {
		super();
		this.batch = batch;
	}

	public Batch() {
	}

	
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}


	
	
	
	
}
