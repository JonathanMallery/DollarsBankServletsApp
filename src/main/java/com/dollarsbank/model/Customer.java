package com.dollarsbank.model;

public class Customer {
	private int customerId;
	private String firstname;
	private String lastname;
	private String username;
	//Password has form to follow
	private String password;
	
	private static int counter = 0;
	
	public Customer(int customerId, String firstname, String lastname, String username, String password) {
		super();
		if (customerId > counter ) {
			counter = customerId;
		}
		this.customerId = customerId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static int generateCustomerId() {
		return ++counter;
	}
	@Override
	public String toString() {
		return "Customer Info \n [CustomerId= " + getCustomerId() + ", Firstname= " + getFirstname()
				+ ", Lastname= " + getLastname() + ", Username= " + getUsername() + "]";
	}
	
	
	
}
