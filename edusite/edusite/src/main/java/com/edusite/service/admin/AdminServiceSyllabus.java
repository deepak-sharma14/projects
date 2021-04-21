package com.edusite.service.admin;

import java.util.List;

import com.edusite.entity.Syllabus;
import com.edusite.model.AddBatchId;
import com.edusite.model.SyllabusModel;

public interface AdminServiceSyllabus {
	
	//Method to GET all teachers
		public List<Syllabus> findAll();
		
		//method to GET a specific teacher by employee id
		public Syllabus findSyllabusById(int syllabusId);
		
		//Method to POST a new/updated teacher
		public void saveSyllabus(SyllabusModel syllabuss );
		
		//Method to DELETE a teacher
		public void deleteSyllabus(int id);

		public void addBatches(AddBatchId syllabusBatch);

}
