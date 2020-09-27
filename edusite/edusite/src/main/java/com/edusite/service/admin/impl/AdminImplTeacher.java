package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.service.admin.AdminServiceTeacher;
@Service
public class AdminImplTeacher implements AdminServiceTeacher {

	@Autowired
	private TeacherReopsitory teacherRepository;
	
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
	public void saveTeacher(Teacher teacher) {
		teacherRepository.save(teacher);
	}

	@Override
	public void deleteTeacher(int id) {

		teacherRepository.deleteById(id);
	}

}
