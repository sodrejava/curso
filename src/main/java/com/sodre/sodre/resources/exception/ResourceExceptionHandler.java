package com.sodre.sodre.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sodre.sodre.services.exceptions.ObjectNotFountException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFountException.class)
	public ResponseEntity<StandardError> ObjectNotFount(ObjectNotFountException e, HttpServletRequest request) {
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis()); 
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(err);
	}
}
