package com.edusite.model;

import java.util.List;

import com.edusite.entity.Batch;
import com.edusite.entity.Student;
import com.edusite.entity.Syllabus;
import com.edusite.entity.Teacher;

public class BatchModel {
	private int batchId;
	
	private String batchName;
	
	private int teacherId;
	
	private int syllabusId;
	
	private List<String> batchNames;
	
	private List<String> studentNames;
	
	private int admissionNumber;
	

	public BatchModel() {
	}

	public BatchModel(int bacthId, String batchName, int teacherId, int syllabusId) {
		super();
		this.batchId = bacthId;
		this.batchName = batchName;
		this.teacherId = teacherId;
		this.syllabusId = syllabusId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
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
	
	public int getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public List<String> getBatchNames() {
		return batchNames;
	}

	public void setBatchNames(List<String> batchNames) {
		this.batchNames = batchNames;
	}
	
	public void addBatchNames(String batchName) {
		this.batchNames.add(batchName);
	}

	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}
	
	public List<String> getStudentNames() {
		return studentNames;
	}

	public void setStudentNames(List<String> studentNames) {
		this.studentNames = studentNames;
	}
	
	public void addStudentNames(String studentName) {
		this.studentNames.add(studentName);
	}

	@Override
	public String toString() {
		return "BatchModel [bacthId=" + batchId + ", batchName=" + batchName + ", teacherId=" + teacherId
				+ ", syllabusId=" + syllabusId + "]";
	}

	public Batch batchConverter(BatchModel batch, Teacher teacher, Syllabus syllabus,Student student) {
		Batch batchEntity = new Batch();
		batchEntity.setBatchId(batch.getBatchId());
		batchEntity.setBatch(batch.getBatchName());
		batchEntity.setSyllabus(syllabus);
		batchEntity.setTeacher(teacher);
		batchEntity.addStudents(student);
		return batchEntity;
	}
	
	
	
	
}
