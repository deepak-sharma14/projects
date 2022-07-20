package com.edusite.service.teacher.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.BatchRepository;
import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Batch;
import com.edusite.entity.Student;
import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.BatchNotFoundException;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.GetBatchNames;
import com.edusite.model.GetStudentNames;
import com.edusite.service.teacher.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherReopsitory teacherReopsitory;
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Override
	public Teacher findTeacherById(Integer employeeId) {
		Optional<Teacher> result =  teacherReopsitory.findById(employeeId);
		
		Teacher teacher = null;
		
		if (result.isPresent()) {
			teacher = result.get();
		}else {
			throw new TeacherNotFoundException();
		}
		return teacher;
	}

	@Override
	public GetBatchNames findBatch(int employeeId) {

		Optional<Teacher> result = teacherReopsitory.findById(employeeId);
		
		Teacher teacher = null;
		
		GetBatchNames batches = new GetBatchNames();
		
		if (result.isPresent()) {
			teacher = result.get();
			for(Batch teachesBatch : teacher.getBatches()) {
				batches.addBatchNames(teachesBatch.getBatchName());
			}
		
		} else {
			throw new TeacherNotFoundException();
		}
		return batches;
	}

	@Override
	public GetStudentNames getStudents(String batch) {
	
		Optional<List<Batch>>  result = batchRepository.findByBatchName(batch); 
	
		
		GetStudentNames studentNames = new GetStudentNames();
		
		if (result.isPresent()) {
			Set<Student> students = result.get().get(0).getStudents();
			for(Student student: students) {
				studentNames.addStudentNames(student.getUser().getName());
			}
		} else {
			throw new BatchNotFoundException();
		}
		
		return studentNames;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
