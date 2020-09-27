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

import com.edusite.entity.Student;
import com.edusite.exceptionhandler.StudentNotFoundExcpetion;
import com.edusite.service.admin.AdminServieStudent;

@RestController
@RequestMapping("/edusite/admin")
public class AdminStudentController {
	
	@Autowired
	private AdminServieStudent adminStudentService;
	
	
	/**
	 * GET mapping /students for finding all Students
	 */
	@GetMapping("/students")
	public List<Student> findAll(){
		return adminStudentService.findAll();
	}

	/**
	 * GET mapping for /student/admissionNumber to get a particular student
	 * 
	 */
	@GetMapping("/student/{admissionNumber}")
	public ResponseEntity<Student> findStudentByAdminNumber(@PathVariable int admissioNnumber){
			Student tempStudent = adminStudentService.findStudent(admissioNnumber);
			if(tempStudent == null){
				throw new StudentNotFoundExcpetion();
			}	
			return new ResponseEntity<>(tempStudent, HttpStatus.ACCEPTED);
		}
	

	
	/**
	 * POST mapping for /student to create a new student
	 * 
	 */
	@PostMapping("/student")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
			student.setAdmissionNumber(0);
			adminStudentService.saveStudent(student);
			return new ResponseEntity<>(student, HttpStatus.ACCEPTED);
	}
	
	
	/**
	 * PUT mapping for /student to update an existing student
	 * 
	 */
	@PutMapping("/students")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		adminStudentService.saveStudent (student);
		return new ResponseEntity<>("Student with admission number " + student.getAdmissionNumber() +
										"has been updated", HttpStatus.ACCEPTED);  
	}

	
	/**
	 * DELETE mapping for /student/admissionNumber to delete a student
	 * 
	 */
	@DeleteMapping("/student/admissionNumber")
	public ResponseEntity<String> deleteStudentByAdmissionNumber(@PathVariable int admissionNumber){
		Student tempStudent = adminStudentService.findStudent(admissionNumber);
		if(tempStudent == null){
			throw new StudentNotFoundExcpetion();
			}
			return new ResponseEntity<>("Student deleted with admission number" + admissionNumber,
											HttpStatus.ACCEPTED);
	}

	

}
