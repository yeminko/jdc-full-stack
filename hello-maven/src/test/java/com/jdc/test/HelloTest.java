package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdc.maven.Course;
import com.jdc.maven.CourseInsert;

public class HelloTest {
	
	private static ClassPathXmlApplicationContext IOC_CONTAINER;
	
	@BeforeAll
	static void initialize() {
		IOC_CONTAINER = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
	}
	
	@AfterAll
	static void close() {
		IOC_CONTAINER.close();
	}

	@Test
	void test() {
		var c = new Course();
		c.setName("Full Stack Spring");
		c.setFees(200000);
		c.setDuration(4);
		
		var insert = IOC_CONTAINER.getBean("insert", CourseInsert.class);
		insert.insert(c);
	}
}
