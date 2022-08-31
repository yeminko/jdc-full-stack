package com.jdc.beans;

public class ZooFactory {
	
	public static ZooInterface defaultZoo() {
		return new Zoo();
	}
	
	public static ZooInterface zooWithAnimalCount(int count) {
		var zoo = new Zoo();
		zoo.setAnimals(new String[count]);
		return zoo;
	}
	
	public static ZooInterface zooWithEmployeeCount(int count) {
		var zoo = new Zoo();
		zoo.setEmployee(count);
		return zoo;
	}
	
	public static ZooInterface zooWithCustomerCount(int count) {
		var zoo = new Zoo();
		zoo.setCustomers(count);
		return zoo;
	}
}
