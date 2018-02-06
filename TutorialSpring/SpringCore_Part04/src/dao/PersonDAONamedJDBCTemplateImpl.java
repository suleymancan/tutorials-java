package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import model.Person;

public class PersonDAONamedJDBCTemplateImpl implements PersonDAONamedJDBCTemplate {

	private final static String INSERT_PERSON = "insert into person (name,surname,birthYear) values(:name,:surname,:birthYear)";
	private final static String SELECT_BYID = "select*from person where id=:id";
	private final static String ALL_SELECT = "select* from person";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public PersonDAONamedJDBCTemplateImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void insertPerson(Person person) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("name", person.getName());
		params.put("surname", person.getSurname());
		params.put("birthYear", person.getBirthYear());

		namedParameterJdbcTemplate.update(INSERT_PERSON, params);
		System.out.println("Person is inserted..." + person);
	}

	@Override
	public Person getPersonById(int id) {
		// Map<String, Object> namedParameters = new HashMap<String, Object>();
		// params.put("id",id);
		// Map de kullanabiliriz.

		SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
		Person person = namedParameterJdbcTemplate.queryForObject(SELECT_BYID, namedParameters, new PersonRowMapper());
		System.out.println("person is found..." + person);
		return person;
	}

	@Override
	public List<Person> getAllPerson() {
		List<Person> personList = namedParameterJdbcTemplate.query(ALL_SELECT, new PersonRowMapper());
		System.out.println("Person list...");
		for (Person person : personList)
			System.out.println(person);
		return personList;
	}

}
