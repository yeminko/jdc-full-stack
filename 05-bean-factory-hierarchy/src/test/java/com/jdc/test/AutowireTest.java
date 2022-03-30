package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.jdc.bean.auto.MyService;

@Configuration
@ComponentScan("com.jdc.bean.auto")
public class AutowireTest {
	
	@Bean
	String message() {
		return "Hello Auto Wiring Demo";
	}
	
	@Test
	void test() {
		try( var context = new AnnotationConfigApplicationContext(AutowireTest.class)) {
			var service = new MyService();
			context.getAutowireCapableBeanFactory().autowireBean(service);
			
			service.showMessage();
		}
	}
}
