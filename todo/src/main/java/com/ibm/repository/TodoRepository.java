package com.ibm.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, UUID>{

	public List<Todo> findTodosByUser(String user);
	
	public List<Todo> findTodosByTargetDate(LocalDate date);
	
}
