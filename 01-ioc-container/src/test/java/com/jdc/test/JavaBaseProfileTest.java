package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.fullstack.config.ProfileConfig;
import com.jdc.fullstack.config.TestConfig;
import com.jdc.fullstack.container.Message;
import com.jdc.fullstack.container.ResourceBean;

public class JavaBaseProfileTest {
	
	@Test
	void test() {
		
		System.setProperty("spring.profiles.active", "test");
		
		try(var context = new AnnotationConfigApplicationContext(ProfileConfig.class, TestConfig.class)) {
			var message = context.getBean(Message.class);
			System.out.println(message.getValue());
			
			var resource = context.getBean(ResourceBean.class);
			System.out.println(resource.data());
		}
	}
}
