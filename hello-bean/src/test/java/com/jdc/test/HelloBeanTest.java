package com.jdc.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.hello.MyBean;

public class HelloBeanTest {
	
	@Test
	void test() {
		
		try(var context = new GenericXmlApplicationContext("classpath:application.xml")) {
			
			var bean = context.getBean(MyBean.class);
			
			assertNotNull(bean);
			assertEquals("Hello Spring Bean", bean.getMessage());
		}
	}
}
