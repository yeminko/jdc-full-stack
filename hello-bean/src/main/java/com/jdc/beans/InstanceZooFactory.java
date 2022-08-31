package com.jdc.beans;

public class InstanceZooFactory {
	
	private boolean bigSize;
	
	public InstanceZooFactory(boolean bigSize) {
		super();
		this.bigSize = bigSize;
	}
	
	public ZooInterface getZoo() {
		var zoo = new Zoo();
		zoo.setAnimals(new String[ bigSize ? 100 : 30]);
		zoo.setCustomers(bigSize ? 1000 : 300);
		zoo.setEmployee(bigSize ? 100 : 30);
		return zoo;
	}
}
