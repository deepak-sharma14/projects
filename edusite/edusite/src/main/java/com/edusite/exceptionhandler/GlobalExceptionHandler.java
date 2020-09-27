package com.edusite.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value = TeacherNotFoundException.class)
	public ResponseEntity<String> exceptionTeacher(TeacherNotFoundException exception){
		return new ResponseEntity<>("Teacher Not found", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = StudentNotFoundExcpetion.class)
	public ResponseEntity<String> exceptionStudent(StudentNotFoundExcpetion exception){
		return new ResponseEntity<>("Student not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = SyllabusNotFoundExcpetion.class)
	public ResponseEntity<String> exceptionSyllabus(SyllabusNotFoundExcpetion exception){
		return new ResponseEntity<>("Syllabus not found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = ClassTestNotFoundExcpetion.class)
	public ResponseEntity<String> exceptionClassTest(ClassTestNotFoundExcpetion exception){
		return new ResponseEntity<>("Test not found",HttpStatus.NOT_FOUND);
	}
	
	
}
