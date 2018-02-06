package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		// id yok
		String name = resultSet.getString("name");
		String surname = resultSet.getString("surname");
		int birthYear = resultSet.getInt("birthYear");

		Person person = new Person(name, surname, birthYear);
		return person;

	}

}
