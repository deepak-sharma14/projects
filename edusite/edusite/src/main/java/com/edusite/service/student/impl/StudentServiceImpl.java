package com.edusite.service.student.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.StudentRepository;
import com.edusite.dao.SyllabusRepository;
import com.edusite.dao.TestRepository;
import com.edusite.entity.ClassTest;
import com.edusite.entity.Student;
import com.edusite.entity.Subject;
import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.ClassTestNotFoundExcpetion;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.SyllabusNotFoundExcpetion;
import com.edusite.model.StudentModel;
import com.edusite.service.student.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TestRepository classTestRepository;
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	
	@Override
	public List<ClassTest> findAll() {
		return classTestRepository.findAll();
	}

	@Override
	public ClassTest findTest(int id) {
		
		Optional<ClassTest> result = classTestRepository.findById(id);
		
		ClassTest classTest = null;
		
		if (result.isPresent()) {
			
			classTest = result.get();
		} else {
			throw new ClassTestNotFoundExcpetion();
		}
		
		return classTest;
	}


	@Override
	public Student findStudent(int admissionNumber) {
		
		Optional<Student> result = studentRepository.findById(admissionNumber);
		
		Student student = null;
		
		if (result.isPresent()) {
			student = result.get();
		} else {
			throw new StudentNotFoundExcpetion();
		}
		
		return student;
	}

	@Override
	public StudentModel getSubject(int admissionNumber) {

		Optional<List<Subject>> result = studentRepository.getSubject(admissionNumber);
		
		StudentModel student = new StudentModel();
		
		if (result.isPresent()) {
			List<Subject> subjects= result.get();
			for (Subject subject : subjects) {
				student.setsubjectInfo(subject.getSubject(), subject.getSubjectCode(), subject.getEmployeeId());
			}
			student.setAdmissionNumber(admissionNumber);
		} else {
			throw new StudentNotFoundExcpetion();
		}
		
		return student;
	}

	@Override
	public Syllabus findSyllabus(int subjectCode) {
		
		Optional<Syllabus> result = syllabusRepository.findById(subjectCode);
		
		Syllabus syllabus = null;
		
		if (result.isPresent()) {
			syllabus = result.get();
		} else {
			throw new SyllabusNotFoundExcpetion();
		}
		
		return syllabus;
	}

}
