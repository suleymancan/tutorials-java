/**
 * 
 */
package hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hibernate.dao.PersonDAOImpl;
import hibernate.domain.Person;

/**
 * @author suleymancan Mar 20, 2018
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired

	private PersonDAOImpl personDAOImpl;

	@Override
	@Transactional
	public void insertPerson(Person person) {
		personDAOImpl.insertPerson(person);
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return personDAOImpl.getPersonById(id);
	}

	@Override
	@Transactional
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personDAOImpl.getAllPersons();
	}

	@Override
	@Transactional
	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		personDAOImpl.updatePerson(person);
	}

	@Override
	@Transactional
	public void deletePerson(int id) {
		// TODO Auto-generated method stub
		personDAOImpl.deletePerson(id);

	}

}
