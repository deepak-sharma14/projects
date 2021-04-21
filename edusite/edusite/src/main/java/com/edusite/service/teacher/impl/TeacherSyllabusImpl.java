package com.edusite.service.teacher.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.SyllabusRepository;
import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.SyllabusNotFoundExcpetion;
import com.edusite.model.SyllabusModel;
import com.edusite.service.teacher.TeacherServiceSyllabus;
@Service
public class TeacherSyllabusImpl implements TeacherServiceSyllabus {
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	
	
	@Override
	public List<Syllabus> findAll() {
		return syllabusRepository.findAll();
	}

	@Override
	//ask about replacing subject with subject code
	public Syllabus findSyllabus(int syllabusId) {
		
		Optional<Syllabus> result = syllabusRepository.findById(syllabusId);
		
		Syllabus syllabus = null;
		
		if (result.isPresent()) {
			syllabus = result.get();
		} else {
			throw new SyllabusNotFoundExcpetion();
		}
		return syllabus;
	}

	@Override
	public void saveSyllabus(SyllabusModel syllabus) {
		
		Syllabus syllabusEntity = syllabus.syllabusConverter(syllabus);
		
		syllabusRepository.save(syllabusEntity);
	}

	@Override
	public void deleteSyllabus(int syllabusId) {
		syllabusRepository.deleteById(syllabusId);
	}

}
