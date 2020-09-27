package com.edusite.service.teacher;

import java.util.List;

import com.edusite.entity.Syllabus;

public interface TeacherServiceSyllabus {

	//Syllabus
	
	//Method to GET all syllabus
	public List<Syllabus> findAll();
		
	
	//Method to GET a single syllabus based on year and subject
	public Syllabus findSyllabus(int subjectCode);

	
	//Method to PUT a new/an updated syllabus 
	public void saveSyllabus(Syllabus syllabus);


	//Method to DELETE a syllabus 
	public void deleteSyllabus(int year, String subject);
	
	
	
	
}
