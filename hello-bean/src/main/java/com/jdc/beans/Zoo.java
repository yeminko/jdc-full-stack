package com.jdc.beans;

public class Zoo extends AbstractZoo{
	
	private int employee;
	private int customers;
	private String[] animals;
	
	public Zoo() {
		System.out.println("Default Constructor");
		animals = new String[0];
	}

	public int getEmployee() {
		return employee;
	}

	public void setEmployee(int employee) {
		this.employee = employee;
	}

	public int getCustomers() {
		return customers;
	}

	public void setCustomers(int customers) {
		this.customers = customers;
	}

	public String[] getAnimals() {
		return animals;
	}

	public void setAnimals(String[] animals) {
		this.animals = animals;
	}
	
	
}
