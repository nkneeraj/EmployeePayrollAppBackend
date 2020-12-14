package com.cg.employeepayollappnew.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmployeeException.class)
	public ResponseEntity<String> globalEmployeeException(EmployeeException e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> globalException(Exception e){
		return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
