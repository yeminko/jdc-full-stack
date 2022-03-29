package com.jdc.fullstack.container;

import org.springframework.stereotype.Component;

@Component
public class HelloService {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
