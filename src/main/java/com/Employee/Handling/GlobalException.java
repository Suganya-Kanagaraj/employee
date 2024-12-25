package com.Employee.Handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Exceptions.AgeException;
import com.Exceptions.NameException;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(AgeException.class)
	public ResponseEntity<Object> ageexc(AgeException ae) {
		return new ResponseEntity<>("Age Not Available", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NameException.class)
	public ResponseEntity<Object> nameExceptio(NameException ne) {
		return new ResponseEntity<>("name not found",HttpStatus.NOT_FOUND);
	}
}
