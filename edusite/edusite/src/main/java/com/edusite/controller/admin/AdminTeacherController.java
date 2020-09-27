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

import com.edusite.entity.Teacher;
import com.edusite.exceptionhandler.TeacherNotFoundException;
import com.edusite.service.admin.AdminServiceTeacher;

@RestController
@RequestMapping("/edusite/admin")
public class AdminTeacherController {

	@Autowired
	private AdminServiceTeacher adminTeacherService;
	
	
	/**
	 * GET mapping for /teacher to find all teachers
	 * 
	 */
	@GetMapping("/teachers")
	public List<Teacher> findAll(){
		return adminTeacherService.findAll();
	}

	
	/**
	 * GET mapping for /teacher/employeeId to find a particular teacher
	 * 
	 */
	@GetMapping("/teacher/{employeeId}")
	public ResponseEntity<Teacher> findStudentByAdminNumber(@PathVariable int employeeId){
			
		Teacher tempTeacher = adminTeacherService.findTeacher(employeeId);
			
			if(tempTeacher == null){
				throw new TeacherNotFoundException();
			}	
			return new ResponseEntity<>(tempTeacher,HttpStatus.ACCEPTED);
		}
	
	/**
	 * POST mapping for /teacher to create a new teacher
	 * 
	 */
	@PostMapping("/teacher")
	public ResponseEntity<Teacher> saveTeacher(@RequestBody Teacher teacher){
			teacher.setEmployeeId(0);
			adminTeacherService.saveTeacher(teacher);
			return new ResponseEntity<>(teacher, HttpStatus.ACCEPTED);
	}
	/**
	 * PUT mapping for /teachers to update a teacher
	 * 
	 */
	@PutMapping("/teachers")
	public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher){
		adminTeacherService.saveTeacher(teacher);
		return new ResponseEntity<>("Teacher has been updated", HttpStatus.ACCEPTED);
	}	


	/**
	 * DELETE mapping for /teacher/employeeId to delete a teacher
	 * 
	 */
	@DeleteMapping("/teacher/{employeeId}")
	public ResponseEntity<String> deleteTeacherByEmployeeId(@PathVariable int emplpoyeeId){
		Teacher tempTeacher = adminTeacherService.findTeacher(emplpoyeeId);
		if(tempTeacher == null){
			throw new TeacherNotFoundException();
		}
			return new ResponseEntity<>("Teacher deleted with employee id " + emplpoyeeId,
											HttpStatus.ACCEPTED) ;
	}

}
