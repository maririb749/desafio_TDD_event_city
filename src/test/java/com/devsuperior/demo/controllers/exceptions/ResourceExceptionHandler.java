package com.devsuperior.demo.controllers.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.demo.service.exceptions.DataBaseException;
import com.devsuperior.demo.service.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
   @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
	  HttpStatus status = HttpStatus.NOT_FOUND;
	  StandardError err = new StandardError();
	  err.setTimestamp(Instant.now());
	  err.setStatus(status.value());
	  err.setError("Resource not found");
	  err.setMessage(e.getMessage());
	  err.setPath(request.getRequestURI());
	  return ResponseEntity.status(status).body(err);
	  

 }
   
   @ExceptionHandler(com.devsuperior.demo.service.exceptions.DataBaseException.class)
  	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
	  HttpStatus status = HttpStatus.BAD_REQUEST;
	  StandardError err = new StandardError();
  	  err.setTimestamp(Instant.now());
  	  err.setStatus(status.value());
  	  err.setError("Database Exception");
  	  err.setMessage(e.getMessage());
  	  err.setPath(request.getRequestURI());
  	  return ResponseEntity.status(status).body(err);
  	  

   }
   

}
