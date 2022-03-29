package com.jdc.event;

import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MessageSubscriber {
	
	@EventListener(Message.class)
	public void onEvent(Message event) {
		System.out.println(event.getValue());
	}
}
