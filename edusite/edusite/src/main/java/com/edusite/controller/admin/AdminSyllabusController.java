package com.edusite.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.model.AddBatchId;
import com.edusite.model.SyllabusModel;
import com.edusite.service.admin.AdminServiceSyllabus;

@RestController
@RequestMapping("/edusite/admin")
public class AdminSyllabusController {

	@Autowired
	private AdminServiceSyllabus adminSyllabusService;
	
	
	/**
	 * GET mapping /syllabi for finding all syllabus
	 */
	@GetMapping("/syllabuses")
	public List<Syllabus> findAll(){
		return adminSyllabusService.findAll();
	}

	/**
	 * GET mapping for /syllabus/{syllabusId} to get a particular syllabus
	 * 
	 */
	@GetMapping("/syllabus/{syllabusId}")
	public ResponseEntity<Syllabus> findSyllabusBySyllabusId(@PathVariable(name = "syllabusId") Integer syllabusId){
			Syllabus tempSyllabus = adminSyllabusService.findSyllabusById(syllabusId);
			if(tempSyllabus == null){
				throw new StudentNotFoundExcpetion();
			}	
			return new ResponseEntity<>(tempSyllabus, HttpStatus.OK);
		}
	

	
	/**
	 * POST mapping for /syllabus to create a new student
	 * 
	 */
	@PostMapping("/syllabus")
	public ResponseEntity<String> saveSyllabus(@RequestBody SyllabusModel syllabus){
			syllabus.setSyllabusId(0);
			adminSyllabusService.saveSyllabus(syllabus);
			return  new ResponseEntity<>("New Syllabus created",HttpStatus.OK);
	}
	
	
	/**
	 * PUT mapping for /syllabus to update an existing syllabus
	 * 
	 */
	@PutMapping("/syllabus")
	public ResponseEntity<String> updateSyllabus(@RequestBody SyllabusModel syllabus){
		adminSyllabusService.saveSyllabus(syllabus);
		return new ResponseEntity<>("Syllabus with syllabusId" + syllabus.getSyllabusId()+
										"has been updated", HttpStatus.OK);  
	}


	/*
	 * PUT mapping for adding One to Many in batch table
	 */
	
	@PutMapping("/syllabus/batches")
	public ResponseEntity<String> addStudents(@RequestBody AddBatchId syllabusBatch){
		adminSyllabusService.addBatches(syllabusBatch);
		return new ResponseEntity<>("Batches with batch Id " + syllabusBatch.getBatchId() +"added to syllabusId " + syllabusBatch.getSyllabusId()
		,HttpStatus.OK);
	}
	
	/**
	 * DELETE mapping for /syllabus/syllabusId to delete a student
	 *  
	 */
	@DeleteMapping("/syllabus/{syllabusId}")
	public ResponseEntity<String> deleteSyllabusBySyllabusId(@PathVariable int syllabusId){
		Syllabus tempSyllabus = adminSyllabusService.findSyllabusById(syllabusId);
		if(tempSyllabus == null){
			throw new StudentNotFoundExcpetion();
			}else {
				adminSyllabusService.deleteSyllabus(syllabusId);
			}
			return new ResponseEntity<>("Syllabus deleted with syllabus Id" + syllabusId,
											HttpStatus.OK);
	}

}
