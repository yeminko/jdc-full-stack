package com.jdc.event.service;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@EventListener(User.class)
	public void send(User user) {
	System.out.printf("Email has been send to %s.%n" , user.getEmail());
	}

}
