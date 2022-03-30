package com.jdc.test;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.bean.ChildService;
import com.jdc.bean.Service;

public class HierarchyBeanFactoryTest {
	
	@Test
	void test()  {
		try(var parent = new GenericXmlApplicationContext()) {
			
			parent.load("classpath:parent.xml");
			parent.refresh();
			
			try(var child = new GenericXmlApplicationContext()) {
				child.setParent(parent);
				child.load("classpath:child.xml");
				child.refresh();
				
				var service = child.getBean("child", Service.class);
				System.out.println(service.handle());
				
				Assertions.assertTrue(child.containsLocalBean("child"));
				Assertions.assertFalse(child.containsLocalBean("parent"));
				Assertions.assertTrue(child.containsBean("parent"));
				
				
				System.out.printf("Bean Definition Count is : %d%n",child.getBeanDefinitionCount());
				System.out.println(Arrays.toString(child.getBeanDefinitionNames()));
			}
		}
	}
}
