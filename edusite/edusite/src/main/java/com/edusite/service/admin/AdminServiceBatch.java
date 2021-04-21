package com.edusite.service.admin;

import java.util.List;

import com.edusite.entity.Batch;
import com.edusite.model.AddStudentNames;
import com.edusite.model.BatchModel;

public interface AdminServiceBatch {
	
	//Method to GET all teachers
		public List<Batch> findAll();
		
		//method to GET a specific teacher by employee id
		public Batch findBatch(int batchId);
		
		//Method to POST a new/updated teacher
		public void saveBatch(BatchModel batch);
		
		//Method to DELETE a teacher
		public void deleteBatch(int batchId);

		public void addStudents(AddStudentNames batchModel);

}
