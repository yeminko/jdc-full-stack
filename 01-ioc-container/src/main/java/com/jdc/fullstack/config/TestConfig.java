package com.jdc.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jdc.fullstack.container.Message;
import com.jdc.fullstack.container.ResourceBean;
import com.jdc.fullstack.container.ResourceTest;

@Configuration
@Profile("test")
public class TestConfig {

	@Bean
	Message testMessage() {
		return new Message("This is Test Message");
	}

	@Bean
	ResourceBean testResource() {
		return new ResourceTest();
	}
}
