package com.edusite.service.teacher.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.edusite.dao.TestRepository;
import com.edusite.entity.ClassTest;
import com.edusite.exceptionhandler.ClassTestNotFoundExcpetion;
import com.edusite.service.teacher.TeacherServiceTest;
@Service
public class TeacherClassTestImpl implements TeacherServiceTest {

	@Autowired
	private TestRepository classTestRepositroy;
	
	@Override
	public List<ClassTest> findAll() {
		return classTestRepositroy.findAll();
	}

	@Override
	public ClassTest findTest(int id) {
		
		Optional<ClassTest> result = classTestRepositroy.findById(id);
		ClassTest classTest = null;
		
		if (result.isPresent()) {
			classTest = result.get();
		} else {
			throw new ClassTestNotFoundExcpetion();
		}
		
		return classTest;
	}

	@Override
	public void saveTest(ClassTest classTest) {
		classTestRepositroy.save(classTest);
	}

	@Override
	public void deleteTest(int id) {
		classTestRepositroy.deleteById(id);
	}

}
