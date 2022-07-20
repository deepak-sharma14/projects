package com.edusite.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "syllabus")
public class Syllabus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "syllabus_id")
	private int syllabusId;

	@Column(name = "subject_name")
	private String subjectName;
	
	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "year")
	private int year;
	
	@Column(name = "content")
	private String syllabusContent;
	
	//Many to one mapping with batch here
	//One syllabus id to many batches
	@JsonManagedReference
	@OneToMany(mappedBy = "syllabus",cascade = CascadeType.ALL)
	private Set<Batch> batches = new HashSet<>();
 	

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

	public int getSyllabusId() {
		return syllabusId;
	}

	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public Set<Batch> getBatches() {
		return batches;
	}

	public void setBatches(Set<Batch> batch) {
		this.batches = batch;
	}
	
	public void addBatches(Batch batch) {
		if(batch == null)
			return;
	
		batches.add(batch);
		batch.setSyllabus(this);
			
	}

	@Override
	public String toString() {
		return "Syllabus [syllabusId=" + syllabusId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", year=" + year + ", syllabusContent=" + syllabusContent + ", batches=" + batches + "]";
	}

	
	
	
	

	
	

}
