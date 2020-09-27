package com.edusite.entity;

import java.io.Serializable;

public class SyllabusId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int year;
	
	private int subjectCode;

	public SyllabusId() {
		/**
		 * Default constructor
		 */
	}

	public int getAdmissionNumber() {
		return year;
	}

	public void setAdmissionNumber(int admissionNumber) {
		this.year = admissionNumber;
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
		result = prime * result + subjectCode;
		result = prime * result + year;
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
		SyllabusId other = (SyllabusId) obj;
		if (subjectCode != other.subjectCode)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	
	

}
