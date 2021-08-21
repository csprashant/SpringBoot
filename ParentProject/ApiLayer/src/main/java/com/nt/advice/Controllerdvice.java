package com.nt.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.StudentNotFoudException;

@RestControllerAdvice
public class Controllerdvice {
	@ExceptionHandler(StudentNotFoudException.class)
	public ResponseEntity<String> handleStudentNotFound(StudentNotFoudException snfe){
		return new ResponseEntity<String>("No student is present with this id",HttpStatus.NOT_FOUND);
	}

}
