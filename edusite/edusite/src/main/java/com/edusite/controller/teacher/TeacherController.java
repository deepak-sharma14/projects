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
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.model.TeacherModel;
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
	@GetMapping("/prfile/{employeeId}")
	public ResponseEntity<Teacher> findTeacherById(int employeeId ){
		Teacher teacher = teacherService.findTeacherById(employeeId);
		
		if (teacher == null) {
			throw new TeacherNotFoundException();
		}
		
		return new ResponseEntity<>(teacher, HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * GET mapping /students for finding all Students
	 */
	@GetMapping("/syllabus")
	public List<Syllabus> findAll(){
		return teacherServiceSyllabus.findAll();
	}

	/**
	 * GET mapping for /student/admissionNumber to get a particular student
	 * 
	 */
	@GetMapping("/syllabus/{subjectCode}")
	public ResponseEntity<Syllabus> findSyllabusBySubjectCode(@PathVariable int subjectCode){
			Syllabus syllabus= teacherServiceSyllabus.findSyllabus(subjectCode);
			if(syllabus == null){
				throw new StudentNotFoundExcpetion();
			}	
			return new ResponseEntity<>(syllabus, HttpStatus.ACCEPTED);
		}
	

	
	/** 
	 * POST mapping for /syllabus to create a new student
	 * 
	 */
	@PostMapping("/syllabuss")
	public ResponseEntity<Syllabus> saveSyllabus(@RequestBody Syllabus syllabus){
			syllabus.setSubjectCode(0);
			teacherServiceSyllabus.saveSyllabus(syllabus);;
			return new ResponseEntity<>(syllabus, HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * PUT mapping for /syllabus to update an existing student
	 * 
	 */
	@PutMapping("/syllabus")
	public ResponseEntity<String> updateSyllabus(@RequestBody Syllabus syllabus){
		teacherServiceSyllabus.saveSyllabus(syllabus);;
		return new ResponseEntity<>("Syllabus with subject code " + syllabus.getSubjectCode()+
										"has been updated", HttpStatus.ACCEPTED);  
	}

	
	/**
	 * DELETE mapping for /syllabus/subjectCode to delete a student
	 * 
	 */
	@DeleteMapping("/syllabus/subjectCode")
	public ResponseEntity<String> deleteSyllabusBySubjectCode(@PathVariable int subjectCode){
		Syllabus syllabus = teacherServiceSyllabus.findSyllabus(subjectCode);
		if(syllabus == null){
			throw new StudentNotFoundExcpetion();
			}
			return new ResponseEntity<>("Syllabus deleted with subject code" + subjectCode,
											HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * GET mapping for /student to get the students taught by the teacher
	 */
	@GetMapping("/student/{employeeId}")
	public ResponseEntity<TeacherModel> findStudentForTeacher(@PathVariable int employeeId){
		
		TeacherModel teacher = teacherService.getStudent(employeeId);
		
		if (teacher == null) {
			throw new TeacherNotFoundException();
		}
		
		return new ResponseEntity<>(teacher, HttpStatus.ACCEPTED);
		
		
	}
	
	
	
	
}
