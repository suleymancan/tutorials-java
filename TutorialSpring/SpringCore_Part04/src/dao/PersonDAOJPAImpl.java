package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Person;

public class PersonDAOJPAImpl implements PersonDAOJPA {

	private EntityManager entityManager;
	private EntityManagerFactory emf;

	public PersonDAOJPAImpl(EntityManagerFactory emf) {
		super();
		this.emf = emf;
		entityManager = emf.createEntityManager();
	}

	@Override
	public void insert(Person person) {
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();

	}

}
