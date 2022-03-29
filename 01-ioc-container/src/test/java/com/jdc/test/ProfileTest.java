package com.jdc.test;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.fullstack.container.Message;
import com.jdc.fullstack.container.ResourceBean;

public class ProfileTest {
	
	@Test
	void test() {
		
		System.setProperty("spring.profiles.active", "development");
		
		try(var context = new GenericXmlApplicationContext()) {
			var environment = context.getEnvironment();
//			environment.setActiveProfiles("publish");
			
			context.load("classpath:/app-config.xml");
			context.refresh();
			
			System.out.println(Arrays.toString(environment.getActiveProfiles()));
			System.out.println(Arrays.toString(environment.getDefaultProfiles()));
			
			var bean = context.getBean(Message.class);
			System.out.println(bean.getValue());
			
			var resouce = context.getBean(ResourceBean.class);
			System.out.println(resouce.data());
		}
	}
}
