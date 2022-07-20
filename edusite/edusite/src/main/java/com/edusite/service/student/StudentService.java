package com.edusite.service.student;

import com.edusite.entity.Student;
import com.edusite.model.GetTeacherAndSubjectNames;
import com.edusite.model.SyllabusModel;

public interface StudentService {
	
	/**
	 * GET method to find a student by admission number
	 */
	public Student findStudent(int admissionNumber);
	
	/**
	 * GET method to find a subject and teacher for a student
	 */
	public GetTeacherAndSubjectNames getSubject(int admissionNumber);
	
	/**
	 * GET method to find syllabus for a subject code
	 */
	public SyllabusModel findSyllabus(String subjectCode);
}
