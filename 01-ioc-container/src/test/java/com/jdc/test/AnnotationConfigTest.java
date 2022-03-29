package com.jdc.test;

import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.fullstack.config.MyBeans;
import com.jdc.fullstack.container.HelloService;

public class AnnotationConfigTest {
	
	static ConfigurableApplicationContext CONTEXT;
	
	static final String BASE_PACKAGE = "com.jdc.fullstack";
	
	@BeforeAll
	static void init() {
		CONTEXT = new AnnotationConfigApplicationContext(MyBeans.class);
	}
	
	@AfterAll
	static void close() {
		CONTEXT.close();
	}
	
	@Test
	void test() {
		var bean = CONTEXT.getBean(HelloService.class); 
		assertNotNull(bean);
		assertNull(bean.getMessage());
	}

}
