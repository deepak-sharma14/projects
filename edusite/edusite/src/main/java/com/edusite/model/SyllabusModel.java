package com.edusite.model;

import com.edusite.entity.Syllabus;

public class SyllabusModel {

	private int syllabusId; 
	
	private String subjectName;
	
	private String subjectCode;

	private int year;
	
	private String content;
	
	

	public SyllabusModel() {
		//Constructor for model class of Syllabus

	}

	public SyllabusModel(String subjectName, String subjectCode, int year, String content) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
		this.year = year;
		this.content = content;
	}
	
	public int getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "SyllabusModel [subjectName=" + subjectName + ", subjectCode=" + subjectCode + ", year=" + year
				+ ", content=" + content + "]";
	}
	
	public Syllabus syllabusConverter(SyllabusModel syllabus) {
		Syllabus syllabusEntity = new Syllabus();
		
		syllabusEntity.setSubjectCode(syllabus.getSubjectCode());
		syllabusEntity.setSubjectName(syllabus.getSubjectName());
		syllabusEntity.setYear(syllabus.getYear());
		syllabusEntity.setSyllabusContent(syllabus.getContent());
		
		return syllabusEntity;
	}

}
