package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.BatchRepository;
import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Batch;
import com.edusite.entity.Teacher;
import com.edusite.entity.User;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.AddBatchId;
import com.edusite.model.TeacherModel;
import com.edusite.service.admin.AdminServiceTeacher;
@Service
public class AdminImplTeacher implements AdminServiceTeacher {

	@Autowired
	private TeacherReopsitory teacherRepository;
	
	@Autowired
	private BatchRepository batchRepository;
	
	
	@Override
	public List<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	public Teacher findTeacher(int id) {

		Optional<Teacher> result = teacherRepository.findById(id);
		
		Teacher teacher = null;
		
		if (result.isPresent()) {
			
			teacher = result.get();
			
		} else {
			throw new TeacherNotFoundException();
			
		}

		return teacher;
	}

	@Override
	public void saveTeacher(TeacherModel teacher) {
		Teacher teacherEntity = teacher.teacherConverter(teacher);
		User user = teacher.userConverter(teacher);
		
		teacherEntity.setUser(user);
		
		teacherRepository.save(teacherEntity);
	
	
	
	}

	@Override
	public void deleteTeacher(int id) {

		teacherRepository.deleteById(id);
	}

	@Override
	public void addBatches(AddBatchId teacherBatch) {
			Optional<Teacher> teacherEntity = teacherRepository.findById(teacherBatch.getTeacherId());
			if (teacherEntity.isPresent()) {
				for(int batchId : teacherBatch.getBatchId()) {
					Optional<Batch> batch = batchRepository.findById(batchId);
					if (batch.isPresent()) {
						teacherEntity.get().getBatches().add(batch.get());
					}
				}
				teacherRepository.save(teacherEntity.get());
			}		
		}		

}
