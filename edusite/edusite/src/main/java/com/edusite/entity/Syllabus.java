package com.edusite.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(SyllabusId.class)
@Table(name = "syllabus")
public class Syllabus {
	
	@Column(name = "subject_name")
	private String subjectName;

	@Id
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Id
	@Column(name = "year")
	private int year;
	
	@Column(name = "content")
	private String syllabusContent;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Column(name = "made_by_teacher")
	private String madeByTeacher;
	

	public Syllabus() {
		/**
		 * Default constructor for syllabus class
		 */

	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getMadeByTeacher() {
		return madeByTeacher;
	}

	public void setMadeByTeacher(String madeByTeacher) {
		this.madeByTeacher = madeByTeacher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSyllabusContent() {
		return syllabusContent;
	}

	public void setSyllabusContent(String syllabusContent) {
		this.syllabusContent = syllabusContent;
	}

	@Override
	public String toString() {
		return "Syllabus [subjectName=" + subjectName + ", year=" + year + ", syllabusContent=" + syllabusContent
				+ ", madeByTeacher=" + madeByTeacher + "]";
	}
	
	

	
	

}
