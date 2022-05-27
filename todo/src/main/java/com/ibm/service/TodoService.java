package com.ibm.service;

import java.time.LocalDate;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.common.exceptions.TodoNotFoundException;
import com.ibm.model.Todo;
import com.ibm.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	TodoRepository todoRepo;
	
	public List<Todo> getTodos()
	{
		return todoRepo.findAll();
	}
	
	public Todo getTodoById(UUID id) {
		return todoRepo.findById(id)
				.orElseThrow(TodoNotFoundException::new);
	}
	
	public List<Todo> getTodosByUser(String user)
	{
		return todoRepo.findTodosByUser(user);
	}
	
	public List<Todo> getTodosByTargetDate(LocalDate targetDate)
	{
		return todoRepo.findTodosByTargetDate(targetDate);
	}
	
	public Todo addTodo(Todo todo){
		return todoRepo.saveAndFlush(todo);
	}
	
	public Todo updateTodo(Todo todo) {
		getTodoById(todo.getId());
		return todoRepo.saveAndFlush(todo);
	}
	
	public boolean deleteTodo(UUID id) {
		getTodoById(id);
		todoRepo.deleteById(id);
		return true;
	}
}
