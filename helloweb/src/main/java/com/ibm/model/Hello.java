package com.ibm.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {

	private String message;
	
	private Date timestamp;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Hello [message=" + message + ", timestamp=" + timestamp + "]";
	}
	 public Hello() {
		
	}
	public Hello(String message, Date timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}
	
	
}
