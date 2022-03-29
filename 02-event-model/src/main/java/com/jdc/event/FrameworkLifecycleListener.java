package com.jdc.event;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class FrameworkLifecycleListener {

	@EventListener(ContextRefreshedEvent.class)
	public void onRefresh(ContextRefreshedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSSS").format(date);
		System.out.println("IoC Container is refreshed at %s.".formatted(dateString));
	}

	@EventListener(ContextClosedEvent.class)
	public void onClose(ContextClosedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSSS").format(date);
		System.out.println("IoC Container is closed at %s.".formatted(dateString));
	}

	@EventListener(ContextStartedEvent.class)
	public void onStart(ContextStartedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSSS").format(date);
		System.out.println("IoC Container is started at %s.".formatted(dateString));
	}
	
	@EventListener(ContextStoppedEvent.class)
	public void onStop(ContextStoppedEvent event) {
		var date = new Date(event.getTimestamp());
		var dateString = new SimpleDateFormat("yyyy/MM/dd HH:mm ss SSSS").format(date);
		System.out.println("IoC Container is stopped at %s.".formatted(dateString));
	}

}
