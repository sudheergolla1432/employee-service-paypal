package com.paypal.bfs.test.employeeserv.utility;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.paypal.bfs.test.employeeserv.api.model.ErrorResponse;

/**
 * Custom exception handler which handles custom exceptions as well as global exception
 * 
 */
@ControllerAdvice
public class EmployeeExceptionHandler {
	
	    @ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException exc) {
			
			ErrorResponse error = new ErrorResponse();
			
			error.setStatus(HttpStatus.NOT_FOUND.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		 }
		
	    @ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException exc) {
			
			ErrorResponse error = new ErrorResponse();
			
			Map<String, String> errors = new HashMap<>();
		    exc.getBindingResult().getAllErrors().forEach((err) -> {
		        String fieldName = ((FieldError) err).getField();
		        String errorMessage = err.getDefaultMessage();
		        errors.put(fieldName, errorMessage);
		    });
			
		    String errorMessage = errors.entrySet().toString();
		    
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(errorMessage);
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		 }
	    
		@ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException exc) {
			
			ErrorResponse error = new ErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}	
		
		@ExceptionHandler
		public ResponseEntity<ErrorResponse> handleException(Exception exc) {
			
			ErrorResponse error = new ErrorResponse();
			
			error.setStatus(HttpStatus.BAD_REQUEST.value());
			error.setMessage(exc.getMessage());
			error.setTimeStamp(System.currentTimeMillis());
			
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}	

}
