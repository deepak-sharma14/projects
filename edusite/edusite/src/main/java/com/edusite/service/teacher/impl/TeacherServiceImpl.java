package com.edusite.service.teacher.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.TeacherReopsitory;
import com.edusite.entity.Student;
import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.TeacherModel;
import com.edusite.service.teacher.TeacherService;
@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	private TeacherReopsitory teacherReopsitory;
	
	@Override
	public Teacher findTeacherById(int employeeId) {
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
	public TeacherModel getStudent(int employeeId) {

		Optional<List<Student>> result = teacherReopsitory.getStudent(employeeId);
		
		TeacherModel teacher = new TeacherModel();
		
		if (result.isPresent()) {
			teacher.setEmployeeId(employeeId);
			
			teacher.setStudent(result.get());
		} else {
			throw new StudentNotFoundExcpetion();
		}
		
		return teacher;
	}

}
