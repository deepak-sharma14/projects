package com.edusite.entity;

import java.io.Serializable;

public class SubjectId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int admissionNumber;
	
	private int subjectCode;

	public SubjectId() {
		/**
		 * Default constructor
		 */
	}

	public int getAdmissionNumber() {
		return admissionNumber;
	}

	public void setAdmissionNumber(int admissionNumber) {
		this.admissionNumber = admissionNumber;
	}

	public int getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(int subjectCode) {
		this.subjectCode = subjectCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + admissionNumber;
		result = prime * result + subjectCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubjectId other = (SubjectId) obj;
		if (admissionNumber != other.admissionNumber)
			return false;
		if (subjectCode != other.subjectCode)
			return false;
		return true;
	}
	
		
	
}
