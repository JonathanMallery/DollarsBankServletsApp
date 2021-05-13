package com.dollarsbank.controller;

import java.util.ArrayList;
import java.util.Optional;

import com.dollarsbank.model.Customer;

public class CustomerController {

	private ArrayList<Customer> customers;

	public CustomerController() {
		super();
		this.customers = new ArrayList<Customer>();
		addCustomer(new Customer(1, "Jonathan", "Mallery","jmall","jmall"));
		addCustomer(new Customer(2, "Drew", "Brees","DB","halloffame"));
		addCustomer(new Customer(3, "You", "Me","meyou","nohim"));
		addCustomer(new Customer(4, "Ed", "Edd","Eddie","cartoon"));
		
	}
	
	public CustomerController(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public ArrayList<Customer> getCustomers() {
		return customers;
	}
	
	
	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public boolean addCustomer(Customer customer) {
		this.customers.add(customer);
		return true;
	}
	
	public Customer findCustomerByCustomerId(int id) {
		Optional<Customer> customerOpt = this.customers.stream()
														.filter(c -> c.getCustomerId()==id)
														.findFirst();
				if(customerOpt.isPresent()) {
				Customer customer = customerOpt.get();
				return customer;
				} else {
				return null;
				}	
	}
	
	public Customer findCustomerByUsername(String username) {
		Optional<Customer> customerOpt = this.customers.stream()
														.filter(c -> c.getUsername().equals(username))
														.findAny();
		if(customerOpt.isPresent()) {
			Customer customer = customerOpt.get();
			return customer;
		} else {
			return null;
		}	
	}
	
	public Customer findCustomerByName(String firstname, String lastname) {
		Optional<Customer> customerOpt = this.customers.stream()
														.filter(c -> c.getFirstname().equals(firstname))
														.findAny();
		
		Optional<Customer> custOpt = customerOpt.stream().filter(c -> c.getLastname().equals(lastname)).findAny();
		
		if(custOpt.isPresent()) {
			Customer customer = custOpt.get();
			return customer;
		} else {
			return null;
		}	
	}

	
}
