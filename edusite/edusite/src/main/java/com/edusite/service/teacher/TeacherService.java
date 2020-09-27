package com.edusite.service.teacher;

import com.edusite.entity.Teacher;
import com.edusite.model.TeacherModel;

public interface TeacherService {

	/**
	 * GET method for viewing the teachers profile 
	 */
	public Teacher findTeacherById(int employeeId);

	public TeacherModel getStudent(int employeeId);
}
