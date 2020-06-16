package com.people10.exceptionhandler;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.people10.exception.UserNotFoundException;

@ControllerAdvice
public class GenericExceptionHandler {
	
	@ExceptionHandler(value = {ConstraintViolationException.class,DataIntegrityViolationException.class})
	public ResponseEntity<ExceptionResponse> handleException(Exception exception) {
		String exceptionMessage = null;
		String exceptionClass = exception.getClass().toString();
		if(exceptionClass.contains("ConstraintViolationException")) {
			exceptionMessage = "Password has not the met the elgibility criteria. Minimum length is 8 and maximum length is 10";
		}else if(exceptionClass.contains("DataIntegrityViolationException")) {
			exceptionMessage = "User name already exists ! ";
		}
		ExceptionResponse exceptionResponse = new ExceptionResponse(exceptionMessage, HttpStatus.BAD_REQUEST.toString());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleException(UserNotFoundException exception) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(exception.getMessage(), HttpStatus.NOT_FOUND.toString());
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
}
