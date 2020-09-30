package com.edusite.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edusite.entity.Student;
import com.edusite.entity.Syllabus;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.exceptionhandler.SyllabusNotFoundExcpetion;
import com.edusite.model.StudentModel;
import com.edusite.service.student.StudentService;

@RestController
@RequestMapping("/edusite/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * GET call for getting the student profile
	 */
	@GetMapping("/profile/{admissionNumber}")
	public ResponseEntity<Student> findStudentById(@PathVariable int admissionNumber){
		Student tempStudent = studentService.findStudent(admissionNumber);
		
		if (tempStudent == null) {
			throw new StudentNotFoundExcpetion();
		}
		return new ResponseEntity<>(tempStudent,HttpStatus.ACCEPTED);
	}
	
	/**
	 * GET call for getting subjects for a admission number
	 */
	@GetMapping("/subject/{admissionnumber}")
	public ResponseEntity<StudentModel> findSubjectById(@PathVariable int admissionNumber){
		StudentModel student = studentService.getSubject(admissionNumber);
		
		if (student == null) {
			throw new StudentNotFoundExcpetion();
		} 
		return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
	} 
	
	/**
	 * GET call for syllabus for the syllabus of  subject with a subject code
	 */
	@GetMapping("/subject/{subjectCode}")
	public ResponseEntity<Syllabus> findSyllabusByCode(@PathVariable int subjectCode){
		Syllabus syllabus = studentService.findSyllabus(subjectCode);
	
		if (syllabus == null) {
			throw new SyllabusNotFoundExcpetion();
		}
	
		return new ResponseEntity<>(syllabus, HttpStatus.ACCEPTED);
	}
	
	
	























}
