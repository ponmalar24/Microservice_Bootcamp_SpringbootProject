package com.ibm.controller;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Todo;
import com.ibm.service.TodoService;

@CrossOrigin
@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	TodoService todoService;
	
	@GetMapping
	public List<Todo> getTodos()
	{
		return todoService.getTodos();
	}
	
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable UUID id)
	{
		return todoService.getTodoById(id);
	}
	
	@GetMapping("/user/{user}")
	public List<Todo> getTodosByUser(@PathVariable String user)
	{
		return todoService.getTodosByUser(user);
	}
	
	@GetMapping("/date/{targetdate}")
	public List<Todo> getTodosByUser(@PathVariable LocalDate targetdate)
	{
		return todoService.getTodosByTargetDate(targetdate);
	}
	
	@PostMapping
	public ResponseEntity<Todo>  addTodo(@Valid @RequestBody Todo todo)
	{
		Todo result = todoService.addTodo(todo);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable UUID id, @Valid @RequestBody Todo todo)
	{
		Todo result = todoService.updateTodo(todo);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location)
				.body(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodoById(@PathVariable UUID id)
	{
		 todoService.deleteTodo(id);
		 return ResponseEntity.noContent().build();
	}
}
