package com.jdc.fullstack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jdc.fullstack.container.Message;
import com.jdc.fullstack.container.ResourceBean;
import com.jdc.fullstack.container.ResourceRelease;

@Configuration
@Profile("release")
public class ProfileConfig {

	@Bean
	Message releaseMessage() {
		return new Message("This is Release Message");
	}

	@Bean
	ResourceBean releaseResource() {
		return new ResourceRelease();
	}
}
