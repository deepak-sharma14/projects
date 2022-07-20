package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.BatchRepository;
import com.edusite.dao.StudentRepository;
import com.edusite.dao.SyllabusRepository;
import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Batch;
import com.edusite.entity.Student;
import com.edusite.entity.Syllabus;
import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.AddStudentNames;
import com.edusite.model.BatchModel;
import com.edusite.service.admin.AdminServiceBatch;

@Service
public class AdminImplBatch implements AdminServiceBatch {
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Autowired
	private TeacherReopsitory teacherReopsitory;
	
	@Autowired
	private SyllabusRepository syllabusRepository;

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Batch> findAll() {
		return batchRepository.findAll();
	}

	@Override
	public Batch findBatch(int batchId) {
		Optional<Batch> result = batchRepository.findById(batchId);
		
		Batch batch = null;
		
		if (result.isPresent()) {
			
			batch = result.get();
			
		} else {
			throw new TeacherNotFoundException();
			
		}

		return batch;
	}

	@Override
	public void saveBatch(BatchModel batch) {
		Optional<Teacher> teacher = teacherReopsitory.findById(batch.getTeacherId());
		Optional<Syllabus> syllabus = syllabusRepository.findById(batch.getSyllabusId());
		Optional<Student> student = studentRepository.findById(batch.getAdmissionNumber());
		Batch batchEntity = new Batch();
		if (teacher.isPresent() && syllabus.isPresent() && student.isPresent()) {
			 batchEntity = batch.batchConverter(batch, teacher.get(), syllabus.get(),student.get());
		}
		batchRepository.save(batchEntity);
	}

	@Override
	public void deleteBatch(int batchId) {
		batchRepository.deleteById(batchId);
	}

	@Override
	public void addStudents(AddStudentNames batches) {
		
		Optional<Batch> batchEntity = batchRepository.findById(batches.getBatchId());
		if (batchEntity.isPresent()) {
			for(int adminNo : batches.getAdmissionNumber()) {
				Optional<Student> student = studentRepository.findById(adminNo);
				if (student.isPresent()) {
					batchEntity.get().getStudents().add(student.get());
				}
			}
			batchRepository.save(batchEntity.get());
		}
			
	}

}
