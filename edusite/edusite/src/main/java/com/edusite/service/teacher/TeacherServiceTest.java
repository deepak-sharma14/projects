package com.edusite.service.teacher;

import java.util.List;

import com.edusite.entity.ClassTest;

public interface TeacherServiceTest {


		
		/**
		 * 
		 *Method to GET all classtest 
		 */
		public List<ClassTest> findAll();
		
		//Method to GET a single ClassTest based on id
		public ClassTest findTest(int id);
		
		//Method to PUT a new /an updated Test
		 public void saveTest(ClassTest classTest);
		 
		 //Method to DELETE a test
		 public void deleteTest(int id);


}
