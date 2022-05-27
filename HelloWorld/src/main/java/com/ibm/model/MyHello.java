package com.ibm.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyHello {

	public MyHello() {
		System.out.println("MyHello object created!" + this.message);
	}
	
	@Value("${message}")
	private String message;

	public String getMessage() {
		return message;
	}

}

