package com.jdc.test;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.fullstack.config.MessageSourceConfig;

//@SpringJUnitConfig(locations = "classpath:/application.xml")
@SpringJUnitConfig(classes = MessageSourceConfig.class)
public class MessageSourceTest {
	
	@Autowired
	ApplicationContext messageSource;
	
	@Test
	void test() {
		var english = messageSource.getMessage("title", new Object[] {"Ye Min Ko"}, Locale.getDefault());
		var myanmar = messageSource.getMessage("title", new Object[] {"Ye Min Ko"}, new Locale("my"));
		var japanese = messageSource.getMessage("title", new Object[] {"Ye Min Ko"}, Locale.JAPANESE);
		System.out.println(english);
		System.out.println(myanmar);
		System.out.println(japanese);
	}
}
