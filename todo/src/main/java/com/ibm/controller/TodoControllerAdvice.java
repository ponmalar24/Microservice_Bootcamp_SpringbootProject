package com.ibm.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ibm.common.exceptions.ErrorDetails;
import com.ibm.common.exceptions.TodoNotFoundException;

@RestControllerAdvice
public class TodoControllerAdvice {

	@ExceptionHandler(TodoNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTodoNotFound(TodoNotFoundException e)
	{
		ErrorDetails ed = new ErrorDetails("Todo-404", "Todo Not Found!", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ed);
	}

	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> handleInvalidTodo(MethodArgumentNotValidException e)
	{
		e.printStackTrace();
		ErrorDetails ed = new ErrorDetails("Todo-400", "Todo Not Found!", LocalDateTime.now());
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
	}
	
}
