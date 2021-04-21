package com.edusite.model;

import java.util.List;

public class AddStudentNames {
	
	private List<Integer> admissionNumber;
	
	private int batchId;
	
	public AddStudentNames() {
		super();
	}

	public List<Integer> getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(List<Integer> admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

}
