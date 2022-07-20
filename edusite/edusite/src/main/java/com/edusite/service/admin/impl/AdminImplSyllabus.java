package com.edusite.service.admin.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusite.dao.BatchRepository;
import com.edusite.dao.SyllabusRepository;
import com.edusite.entity.Batch;
import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.model.AddBatchId;
import com.edusite.model.SyllabusModel;
import com.edusite.service.admin.AdminServiceSyllabus;

@Service
public class AdminImplSyllabus implements AdminServiceSyllabus {
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	
	@Autowired
	private BatchRepository batchRepository;

	@Override
	public List<Syllabus> findAll() {
		
		return syllabusRepository.findAll();
	
	}

	@Override
	public Syllabus findSyllabusById(int syllabusId) {

		Optional<Syllabus> result = syllabusRepository.findById(syllabusId);
		
		Syllabus syllabus = null;
		
		if (result.isPresent()) {
			
			syllabus = result.get();
		} else {
			throw  new StudentNotFoundExcpetion();
		}
	
		return syllabus;
	}

	@Override
	public void saveSyllabus(SyllabusModel syllabus) {
		//converter method here to convert model to entity
				Syllabus syllabusEntity = syllabus.syllabusConverter(syllabus);
				
				syllabusRepository.save(syllabusEntity);
	}

	@Override
	public void deleteSyllabus(int syllabusId) {
		syllabusRepository.deleteById(syllabusId);
	}

	@Override
	public void addBatches(AddBatchId syllabusBatch) {
		Optional<Syllabus> syllabusEntity = syllabusRepository.findById(syllabusBatch.getSyllabusId());
		if (syllabusEntity.isPresent()) {
			for(int batchId : syllabusBatch.getBatchId()) {
				Optional<Batch> batch = batchRepository.findById(batchId);
				if (batch.isPresent()) {
					syllabusEntity.get().getBatches().add(batch.get());
				}
			}
			syllabusRepository.save(syllabusEntity.get());
		}		
	}

}
