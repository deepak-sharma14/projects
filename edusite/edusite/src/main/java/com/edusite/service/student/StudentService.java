package com.edusite.service.student;

import java.util.List;

import com.edusite.entity.ClassTest;
import com.edusite.entity.Student;
import com.edusite.model.GetTeacherAndSubjectNames;
import com.edusite.model.SyllabusModel;

public interface StudentService {
	
	/**
	 * Method to GET all class tests
	 */
	public List<ClassTest> findAll();

	/**
	 * Method to GET a single Test based on id
	 */
	public ClassTest findTest(int id);
	
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
