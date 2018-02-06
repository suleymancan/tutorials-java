package dao;

import java.sql.SQLException;

import model.Person;

public interface PersonJDBCDAO {

	public void insert(Person person) throws SQLException;
}
