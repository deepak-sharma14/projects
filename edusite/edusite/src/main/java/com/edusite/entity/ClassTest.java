package com.edusite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ClassTest {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "test_id")
	private int testId;
	
	@Column(name = "time_of_submission")
	private int timeOfSubmission;
	
	
	
	
	public ClassTest(int timeOfSubmission ) {
		super();
		this.timeOfSubmission = timeOfSubmission;
	}

	public ClassTest() {
	}

	public int getTimeOfSubmission() {
		return timeOfSubmission;
	}

	public void setTimeOfSubmission(int timeOfSubmission) {
		this.timeOfSubmission = timeOfSubmission;
	}


	@Override
	public String toString() {
		return "Test [timeOfSubmission=" + timeOfSubmission + ", ]";
	}
	
	
	
	
	
	
}
