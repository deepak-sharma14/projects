package com.edusite.service.admin;

import java.util.List;

import com.edusite.entity.Teacher;

public interface AdminServiceTeacher {

	//Method to GET all teachers
	public List<Teacher> findAll();
	
	//method to GET a specific teacher by employee id
	public Teacher findTeacher(int id);
	
	//Method to POST a new/updated teacher
	public void saveTeacher(Teacher teacher);
	
	//Method to DELETE a teacher
	public void deleteTeacher(int id);
	
}
