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

import com.edusite.entity.Batch;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.AddStudentNames;
import com.edusite.model.BatchModel;
import com.edusite.service.admin.AdminServiceBatch;

@RestController
@RequestMapping("/edusite/admin")
public class AdminBatchController {
	
	@Autowired
	private AdminServiceBatch adminBatchService;
	
	
	/**
	 * GET mapping for /batches to find all batches
	 * 
	 */
	@GetMapping("/batches")
	public List<Batch> findAll(){
		return adminBatchService.findAll();
	}

	
	/**
	 * GET mapping for /batch/batchId to find a particular batch
	 * 
	 */
	@GetMapping("/batch/{batchId}")
	public ResponseEntity<Batch> findBatchByBatchId(@PathVariable int batchId){
			
		Batch tempBatch= adminBatchService.findBatch(batchId);
			
			if(tempBatch == null){
				throw new TeacherNotFoundException();
			}	
			return new ResponseEntity<>(tempBatch,HttpStatus.OK);
		}
	
	/**
	 * POST mapping for /batch to create a new batch
	 * 
	 */
	@PostMapping("/batch")
	public ResponseEntity<BatchModel> saveBatch(@RequestBody BatchModel batch){
			batch.setBatchId(0);
			adminBatchService.saveBatch(batch);
			return new ResponseEntity<>(batch, HttpStatus.OK);
	}
	/**
	 * PUT mapping for /batches to update a batch
	 * 
	 */
	@PutMapping("/batches")
	public ResponseEntity<String> updateBatch(@RequestBody BatchModel batch){
		adminBatchService.saveBatch(batch);
		return new ResponseEntity<>("Batch has been updated", HttpStatus.OK);
	}	
	
	/*
	 * PUT mapping for adding Students in student_batch table
	 */
	
	@PutMapping("/batch/students")
	public ResponseEntity<String> addStudents(@RequestBody AddStudentNames batchModel){
		adminBatchService.addStudents(batchModel);
		return new ResponseEntity<>("Student with admission Number " + batchModel.getAdmissionNumber() +"added to bathId " + batchModel.getBatchId()
		,HttpStatus.OK);
	}


	/**
	 * DELETE mapping for /batch/batchId to delete a batch
	 * 
	 */
	@DeleteMapping("/batch/{batchId}")
	public ResponseEntity<String> deleteBatchByBatchId(@PathVariable int batchId){
		Batch batch = adminBatchService.findBatch(batchId);
		if(batch == null){
			throw new TeacherNotFoundException();
		}else {
			adminBatchService.deleteBatch(batchId);
		}
			return new ResponseEntity<>("Batch deleted with employee id " + batchId,
											HttpStatus.OK) ;
	}

}
