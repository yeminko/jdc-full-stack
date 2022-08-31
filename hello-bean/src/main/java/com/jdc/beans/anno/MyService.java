package com.jdc.beans.anno;

import org.springframework.stereotype.Component;

@Component
public class MyService {
	
	public MyService() {
		System.out.println("Default My Service");
	}
	
	public MyService(int count) {
		System.out.println("My service count: " + count);
	}
}
