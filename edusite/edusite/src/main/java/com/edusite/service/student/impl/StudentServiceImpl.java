package com.edusite.service.student.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.StudentRepository;
import com.edusite.dao.SyllabusRepository;
import com.edusite.entity.Batch;
import com.edusite.entity.Student;
import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.SyllabusNotFoundExcpetion;
import com.edusite.model.GetTeacherAndSubjectNames;
import com.edusite.model.SyllabusModel;
import com.edusite.service.student.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	

	

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
	public GetTeacherAndSubjectNames getSubject(int admissionNumber) {

		Optional<Student> result = studentRepository.findById(admissionNumber);
		
		GetTeacherAndSubjectNames student = new GetTeacherAndSubjectNames();
		
		if (result.isPresent()) {
			
			Set<Batch> studentBatches = result.get().getBatches();
			student.setAdmissionNumber(admissionNumber);
			for(Batch batch : studentBatches) {	
				student.addTeacherName(batch.getTeacher().getUser().getName());
				student.addSubjectName(batch.getSyllabus().getSubjectName());
			}

		} else {
			throw new StudentNotFoundExcpetion();
		}
		return student;
	}

	@Override
	public SyllabusModel findSyllabus(String subjectName) {
		
		Optional<Syllabus> result = syllabusRepository.findBySubjectName(subjectName);
		
		SyllabusModel syllabus = new SyllabusModel();
		
		if (result.isPresent()) {
			syllabus.setSubjectName(result.get().getSubjectName());
			syllabus.setContent(result.get().getSyllabusContent());
			syllabus.setSubjectCode(result.get().getSubjectCode());
			syllabus.setYear(result.get().getYear());
			
		} else {
			throw new SyllabusNotFoundExcpetion();
		}
		
		return syllabus;
	}

}
