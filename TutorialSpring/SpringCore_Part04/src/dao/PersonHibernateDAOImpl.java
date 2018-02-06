package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Person;

@Repository("personHibernateDAOImpl")
public class PersonHibernateDAOImpl implements PersonHibernateDAO {

	// JPA da EntityManagerFactory ->

	@Autowired
	// Autowired icin setter ya da constructor a gerek yoktur!
	private SessionFactory sessionFactory;

	// JPA da EntityManager

	public Session getSession() {
		return sessionFactory.openSession();
	}

	@Override
	public void insert(Person person) {
		// JPA da EntityTransaction

		Session session = getSession();
		Transaction transacion = session.beginTransaction();
		session.persist(person);
		transacion.commit();
		session.close();
	}
}
