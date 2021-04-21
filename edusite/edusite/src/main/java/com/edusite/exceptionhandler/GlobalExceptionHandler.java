package com.edusite.exceptionhandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	
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
	
	@ExceptionHandler(value = BatchNotFoundException.class)
	public ResponseEntity<String> exceptionBatch(BatchNotFoundException exception){
		return new ResponseEntity<>("Batch not found", HttpStatus.NOT_FOUND);
	}
	
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<Object> handle(Exception ex, 
	                HttpServletRequest request, HttpServletResponse response) {
	        if (ex instanceof NullPointerException) {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	        }
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	
}
