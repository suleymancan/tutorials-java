package _01jdbcprogrammatic.transaction.dao;

import _01jdbcprogrammatic.transaction.model.Adress;
import _01jdbcprogrammatic.transaction.model.Person;

public interface PersonDAO {

	public void insert(Person person);

	public void insertAdress(Adress address);

	public void updatePersonAdress(int id, int adressId);
}
