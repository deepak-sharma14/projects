package com.edusite.model;

import java.util.List;

public class AddBatchId {
	
	private List<Integer> batchId;
	
	private int teacherId;
	
	private int syllabusId;

	public AddBatchId() {
		super();
	}

	public AddBatchId(List<Integer> batchId, int teacherId, int syllabusId) {
		super();
		this.batchId = batchId;
		this.teacherId = teacherId;
		this.syllabusId = syllabusId;
	}

	public List<Integer> getBatchId() {
		return batchId;
	}

	public void setBatchId(List<Integer> batchId) {
		this.batchId = batchId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}
	
	

}
