/**
 * 
 */
package jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jpa.dao.PersonDAOImpl;
import jpa.domain.Person;

/**
 * @author suleymancan Mar 20, 2018
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDAOImpl personDAOImpl;

	@Override

	public void insertPerson(Person person) {
		personDAOImpl.insertPerson(person);
	}

	@Override

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return personDAOImpl.getPersonById(id);
	}

	@Override

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDAOImpl.getAllPersons();
	}

	@Override

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		personDAOImpl.updatePerson(person);
	}

	@Override

	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		personDAOImpl.deletePerson(id);

	}

}
