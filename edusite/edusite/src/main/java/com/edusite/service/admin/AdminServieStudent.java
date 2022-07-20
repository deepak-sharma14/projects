package com.edusite.service.admin;

import java.util.List;

import com.edusite.entity.Student;
import com.edusite.model.StudentModel;

public interface AdminServieStudent {

	//Method to GET all student
	public List<Student> findAll();
	
	//Method to GET a particular student by admission number
	public Student findStudentById(int id);
	
	//Method to POST a new/ an updated Student
	public void saveStudent(StudentModel student);
	
	//Method to DELETE a student by id
	public void deleteStudent(int id);
}
