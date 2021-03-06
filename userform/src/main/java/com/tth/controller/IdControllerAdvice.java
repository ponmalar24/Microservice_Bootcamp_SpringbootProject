package com.tth.controller;

import java.time.LocalDateTime;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tth.common.exceptions.ErrorDetails;
import com.tth.common.exceptions.IdNotFoundException;


@RestControllerAdvice
public class IdControllerAdvice {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleConversionFactorNotFound(IdNotFoundException e)
	{
		ErrorDetails ed = new ErrorDetails("ID-404", "ID Not Found!", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}
	
}
