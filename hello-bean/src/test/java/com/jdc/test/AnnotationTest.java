package com.jdc.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jdc.beans.anno.MyService;

public class AnnotationTest {
	
	@Test
	void test() {
		try(var context = new AnnotationConfigApplicationContext()) {
			context.scan("com.jdc.beans.anno");
			
			context.registerBeanDefinition("myNumber", getMyNumberDefinition());
			
			context.refresh();
			
			var bean = context.getBean("defaultService",MyService.class);
			Assertions.assertNotNull(bean);
		}
	}

	private BeanDefinition getMyNumberDefinition() {
		var myNumber = new GenericBeanDefinition();
		myNumber.setBeanClass(Integer.class);
		myNumber.setFactoryMethodName("parseInt");
		var args = new ConstructorArgumentValues();
		args.addGenericArgumentValue("100");
		myNumber.setConstructorArgumentValues(args);
		return myNumber;
	}
}
