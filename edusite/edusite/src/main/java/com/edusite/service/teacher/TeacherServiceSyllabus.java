package com.edusite.service.teacher;

import java.util.List;

import com.edusite.entity.Syllabus;
import com.edusite.model.SyllabusModel;

public interface TeacherServiceSyllabus {

	//Syllabus
	
	//Method to GET all syllabus
	public List<Syllabus> findAll();
		
	
	//Method to GET a single syllabus based on year and subject
	public Syllabus findSyllabus(int syllabusId);

	
	//Method to PUT a new/an updated syllabus 
	public void saveSyllabus(SyllabusModel syllabus);


	//Method to DELETE a syllabus 
	public void deleteSyllabus(int syllabusId);
	
	
	
	
}
