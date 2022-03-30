package com.jdc.bean;

public class ParentService implements Service {
	@Override
	public String handle() {
		return "Message for Parent Service";
	}
}
