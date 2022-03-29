package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.event.FrameworkLifecycleListener;
import com.jdc.event.Message;
import com.jdc.event.service.User;
import com.jdc.event.service.UserRegistrationService;

public class HelloEventSubscriber {
	
	private static final String CONFIG = "com.jdc.event";

	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.scan(CONFIG);
			context.refresh();
//			context.start();
//			context.stop();
			
			var message = new Message("Hello Custom Event Message.");
//			var event = new PayloadApplicationEvent<Message>(context, message);
			context.publishEvent(message);
			
			var user = new User();
			user.setName("Thidar");
			user.setEmail("thida@gmail.com");
			
			var service = context.getBean(UserRegistrationService.class);
			service.register(user);
		}
	}
}
