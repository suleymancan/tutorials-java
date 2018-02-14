package _02jpadeclarative.transaction.dao;

import java.util.List;

import _02jpadeclarative.transaction.model.Customer;





public interface CustomerDAO {

	public void insertCustomer(Customer customer);

	public List<Customer> findAllCustomer();
}
