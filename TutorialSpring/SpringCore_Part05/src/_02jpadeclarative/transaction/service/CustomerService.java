package _02jpadeclarative.transaction.service;

import java.util.List;

import _02jpadeclarative.transaction.model.Customer;

public interface CustomerService {

	public void insertCustomerData(Customer customer);

	public List<Customer> listCustomers();
}
