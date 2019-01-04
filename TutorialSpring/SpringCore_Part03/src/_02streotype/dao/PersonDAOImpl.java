package _02streotype.dao;

import org.springframework.stereotype.Repository;

import _02streotype.model.Person;

@Repository
public class PersonDAOImpl implements PersonDAO {

	@Override
	public void insertPerson(Person person) {
		System.out.println("PersonDAO#insertPerson");
		
	}

	
	
}
