package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.Resource;

import com.jdc.fullstack.container.ResourceBean;
import com.jdc.fullstack.container.ResourceTest;

public class ProfileAnnotationTest {
	
	@Test
	void test() {
		System.setProperty("spring.profiles.active", "release");
		try(var context = new AnnotationConfigApplicationContext("com.jdc.fullstack")) {
			
			var resource = context.getBean(ResourceBean.class);
			System.out.println(resource.data());
		}
	}
}
