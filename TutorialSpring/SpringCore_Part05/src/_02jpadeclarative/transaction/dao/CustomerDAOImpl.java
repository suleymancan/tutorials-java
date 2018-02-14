package _02jpadeclarative.transaction.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import _02jpadeclarative.transaction.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// entityManager'i inject ettik.
	@PersistenceContext
	EntityManager entityManager;
	private static final String ALL_CUSTOMERS = "Select c from Customer c";

	@Override
	public void insertCustomer(Customer customer) {
		entityManager.persist(customer);

	}

	@Override
	public List<Customer> findAllCustomer() {
		TypedQuery<Customer> query = entityManager.createQuery(ALL_CUSTOMERS, Customer.class);
		return query.getResultList();
	}

}
