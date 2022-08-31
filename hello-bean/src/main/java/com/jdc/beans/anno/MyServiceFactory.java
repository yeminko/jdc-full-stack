package com.jdc.beans.anno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class MyServiceFactory {
	
	@Bean
	public MyService defaultService(int count) {
		return new MyService(count);
	}
}
