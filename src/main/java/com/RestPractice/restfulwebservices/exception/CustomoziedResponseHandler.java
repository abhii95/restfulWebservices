package com.RestPractice.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomoziedResponseHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(request.getDescription(false), ex.getMessage(),
				new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(UsernotFoundException.class)
	public final ResponseEntity<Object> handleUsernotFoundExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(request.getDescription(false), ex.getMessage(),
				new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getBindingResult().toString(), "Validation Failed",
				new Date());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
