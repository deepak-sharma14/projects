package com.edusite.controller.teacher;

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
import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.BatchNotFoundException;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.GetBatchNames;
import com.edusite.model.GetStudentNames;
import com.edusite.model.SyllabusModel;
import com.edusite.service.teacher.TeacherService;
import com.edusite.service.teacher.TeacherServiceSyllabus;

@RestController
@RequestMapping("/edusite/teacher")
public class TeacherController {

	@Autowired
	private TeacherServiceSyllabus teacherServiceSyllabus;
	
	@Autowired
	private TeacherService teacherService;
	
	

	/**
	 * GET mapping /profile to get teacher profile
	 */
	@GetMapping("/profile/{employeeId}")
	public ResponseEntity<Teacher> findTeacherById(Integer employeeId ){
		Teacher teacher = teacherService.findTeacherById(employeeId);
		
		if (teacher == null) {
			throw new TeacherNotFoundException();
		}
		
		return new ResponseEntity<>(teacher, HttpStatus.OK);
	}
	
	
	/**
	 * GET mapping /syllabus for finding all syllabuses
	 */
	@GetMapping("/syllabus")
	public List<Syllabus> findAll(){
		return teacherServiceSyllabus.findAll();
	}

	/**
	 * GET mapping for /syllabus/syllabusId to get a particular syllabus
	 * 
	 */
	@GetMapping("/syllabus/{syllabusId}")
	public ResponseEntity<Syllabus> findSyllabusBySubjectCode(@PathVariable int syllabusId){
			Syllabus syllabus= teacherServiceSyllabus.findSyllabus(syllabusId);
			if(syllabus == null){
				throw new StudentNotFoundExcpetion();
			}	
			return new ResponseEntity<>(syllabus, HttpStatus.OK);
		}
	

	
	/** 
	 * POST mapping for /syllabus to create a new syllabus
	 * 
	 */
	@PostMapping("/syllabuss")
	public ResponseEntity<SyllabusModel> saveSyllabus(@RequestBody SyllabusModel syllabus){
			syllabus.setSubjectCode("0");
			teacherServiceSyllabus.saveSyllabus(syllabus);
			return new ResponseEntity<>(syllabus, HttpStatus.OK);
	}
	
	
	/**
	 * PUT mapping for /syllabus to update an existing syllabus
	 * 
	 */
	@PutMapping("/syllabus")
	public ResponseEntity<String> updateSyllabus(@RequestBody SyllabusModel syllabus){
		teacherServiceSyllabus.saveSyllabus(syllabus);
		return new ResponseEntity<>("Syllabus with subject code " + syllabus.getSubjectCode()+
										"has been updated", HttpStatus.OK);  
	}

	
	/**
	 * DELETE mapping for /syllabus/subjectCode to delete a syllabus
	 * 
	 */
	@DeleteMapping("/syllabus/{syllabusId}")
	public ResponseEntity<String> deleteSyllabusBySubjectCode(@PathVariable int syllabusId){
		Syllabus syllabus = teacherServiceSyllabus.findSyllabus(syllabusId);
		if(syllabus == null){
			throw new StudentNotFoundExcpetion();
			}
			return new ResponseEntity<>("Syllabus deleted with subject code" + syllabusId,
											HttpStatus.OK);
	}

	/**
	 * 2 step process for getting students...
	 * first find all batches of the teacher 
	 * second, find students for that particular batch
	 */
	

	/**
	 * Step1
	 * GET mapping for all bacthes of teacher
	 */
	@GetMapping("/batchName/{teacherId}")
	public ResponseEntity<GetBatchNames> findBatches(@PathVariable int teacherId){
		
		GetBatchNames batches = teacherService.findBatch(teacherId);
		
		if (batches == null) {
			throw new BatchNotFoundException();
		}
		
		return new ResponseEntity<>(batches,HttpStatus.OK);
		
	}
	
	/**
	 * Step2
	 * GET mapping for all student for the batch
	 */
	@GetMapping("/student/{batchName}")
	public ResponseEntity<GetStudentNames> findStudents(@PathVariable String batchName){
		
		GetStudentNames students = teacherService.getStudents(batchName);
		
		if (students == null) {
			throw new StudentNotFoundExcpetion();
		}
		
		return new ResponseEntity<>(students,HttpStatus.OK);
	}
	
	
	
	

}
