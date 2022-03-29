package com.jdc.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.fullstack.container.HelloService;

@Configuration
public class MyBeans {
	
	@Bean
	HelloService service() {
		return new HelloService();
	}
}
