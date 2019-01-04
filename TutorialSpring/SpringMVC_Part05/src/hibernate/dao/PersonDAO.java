/**
 * 
 */
package hibernate.dao;

import java.util.List;

import hibernate.domain.Person;

/**
 * @author suleymancan Mar 20, 2018
 */
public interface PersonDAO {

	public void insertPerson(Person person);

	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public void updatePerson(Person person);

	public void deletePerson(int id);

}
