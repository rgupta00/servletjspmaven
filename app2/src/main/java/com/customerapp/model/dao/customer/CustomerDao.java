package com.customerapp.model.dao.customer;

import java.util.List;

public interface CustomerDao {
	public List<Customer> getAllCustomers();
	public Customer getCustomerById(int customerId);
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(int customerId, String address);
	public Customer removeCustomer(int customerId);
}
