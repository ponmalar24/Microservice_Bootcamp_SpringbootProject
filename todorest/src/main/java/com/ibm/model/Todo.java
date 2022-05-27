package com.ibm.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private UUID id;
	
	@NotBlank(message = "User cannot be null or empty")
	private String user;
	
	@Size(min = 3, max = 200, message = "Task must be b/w 3-200 characters")
	private String task;
	
	@Column(name = "TARGETDATE")
	@FutureOrPresent
	private LocalDate targetDate;
	
	private boolean done;
	
	public Todo() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public LocalDate getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDate targetDate) {
		this.targetDate = targetDate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Todo(UUID id, String user, String task, LocalDate targetDate, boolean done) {
		super();
		this.id = id;
		this.user = user;
		this.task = task;
		this.targetDate = targetDate;
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", user=" + user + ", task=" + task + ", targetDate=" + targetDate + ", done=" + done
				+ "]";
	}
	

}
