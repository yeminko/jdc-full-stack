package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.jdc.beans.AbstractZoo;
import com.jdc.beans.Zoo;
import com.jdc.beans.ZooInterface;

public class ZooTest {

	@Test
	void Test() {
		try(var context = new GenericXmlApplicationContext()) {
			context.load(new ClassPathResource("application.xml"));
			context.refresh();
			
			var bean1 = context.getBean(ZooInterface.class);
			var bean2 = context.getBean(AbstractZoo.class);
			var bean3 = context.getBean(Zoo.class);
			
			System.out.println(bean1);
			System.out.println(bean2);
			System.out.println(bean3);
		}
	}
}
