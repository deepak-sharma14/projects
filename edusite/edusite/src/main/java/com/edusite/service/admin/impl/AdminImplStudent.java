package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.StudentRepository;
import com.edusite.entity.Student;
import com.edusite.entity.User;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.model.StudentModel;
import com.edusite.service.admin.AdminServieStudent;
@Service
public class AdminImplStudent implements AdminServieStudent {
	
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(int id) {
		
		Optional<Student> result = studentRepository.findById(id);
		
		Student student = null;
		
		if (result.isPresent()) {
			
			student = result.get();
		} else {
			throw  new StudentNotFoundExcpetion();
		}
	
		return student;
	}

	@Override
	public void saveStudent(StudentModel student) {
		//converter method here to convert model to entity
		Student studentEntity = student.studentConverter(student);
		User user = student.userConverter(student);
		
		studentEntity.setUser(user);
		
		studentRepository.save(studentEntity);
		
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
