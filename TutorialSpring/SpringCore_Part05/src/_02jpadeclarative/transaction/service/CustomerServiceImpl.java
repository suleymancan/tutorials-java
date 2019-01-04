package _02jpadeclarative.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _02jpadeclarative.transaction.dao.AdressDAO;
import _02jpadeclarative.transaction.dao.CustomerDAO;
import _02jpadeclarative.transaction.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private AdressDAO adressDAO;

	// transaction işlemlerini annotationla yaptık.
	@Transactional
	@Override
	public void insertCustomerData(Customer customer) {
		customerDAO.insertCustomer(customer);
		adressDAO.insertAdress(customer.getAdress());

	}

	@Transactional(readOnly = true)
	@Override
	public List<Customer> listCustomers() {

		return customerDAO.findAllCustomer();

	}

}
