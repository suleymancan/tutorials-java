package _02jpadeclarative.transaction.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import _02jpadeclarative.transaction.model.Adress;

@Repository
public class AdressDAOImpl implements AdressDAO {

	@PersistenceContext
	private EntityManager entityManager;

	// transaction acmaya/kapatmaya gerek yok. service katmanında yapacağız.
	@Override
	public void insertAdress(Adress adress) {
		entityManager.persist(adress);

	}

}
