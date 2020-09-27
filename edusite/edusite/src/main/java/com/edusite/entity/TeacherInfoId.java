package com.edusite.entity;

import java.io.Serializable;

public class TeacherInfoId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int employeeId;
	
	private String batch;

	public TeacherInfoId() {
		super();
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batch == null) ? 0 : batch.hashCode());
		result = prime * result + employeeId;
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
		TeacherInfoId other = (TeacherInfoId) obj;
		if (batch == null) {
			if (other.batch != null)
				return false;
		} else if (!batch.equals(other.batch))
			return false;
		if (employeeId != other.employeeId)
			return false;
		return true;
	}
	
	

}
