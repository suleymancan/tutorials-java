package dao;

import java.util.List;

import model.Person;

public interface PersonDAONamedJDBCTemplate {

	public void insertPerson(Person person) throws Exception;
	public Person getPersonById(int id);
	public List<Person> getAllPerson();
}
