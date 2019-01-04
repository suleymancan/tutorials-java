/**
 * 
 */
package jpa.service;

import java.util.List;

import jpa.domain.Person;

/**
 * @author suleymancan Mar 20, 2018
 */
public interface PersonService {

	public void insertPerson(Person person);

	public Person getPersonById(int id);

	public List<Person> getAllPersons();

	public void updatePerson(Person person);

	public void deletePerson(int id);
}
