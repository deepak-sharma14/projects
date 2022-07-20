package com.edusite.service.teacher;

import com.edusite.entity.Teacher;
import com.edusite.model.GetBatchNames;
import com.edusite.model.GetStudentNames;

public interface TeacherService {

	/**
	 * GET method for viewing the teachers profile 
	 */
	public Teacher findTeacherById(Integer employeeId);

	public GetBatchNames findBatch(int employeeId);

	public GetStudentNames getStudents(String batch);
}
