package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdc.fullstack.container.HelloService;

public class HelloServiceTest {
	private HelloService service;
	private static ClassPathXmlApplicationContext CONTAINER;
	
	@BeforeAll
	static void start() {
		CONTAINER = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
	}
	
	@AfterAll
	static void end() {
		CONTAINER.close();
	}
	
	@Test
	void test() {
		service = CONTAINER.getBean("service", HelloService.class);
		Assertions.assertNotNull(service);
		Assertions.assertEquals("Hello Spring Container", service.getMessage());
	}
}
