package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.StudentRepository;
import com.edusite.entity.Student;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
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
	public Student findStudent(int id) {
		
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
	public void saveStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

}
