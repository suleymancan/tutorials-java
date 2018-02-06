package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import model.Person;

public class PersonJDBCTemplateDAOImpl implements PersonJDBCTemplateDAO {

	private final static String INSERT_PERSON = "insert into person(id, name, surname, birthYear) values(?,?,?,?) ";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertPerson(Person person) throws Exception {
		// parametre sayısı ve sırası önemli.
		Object[] insertParams = new Object[] { person.getId(), person.getName(), person.getSurname(),
				person.getBirthYear() };
		jdbcTemplate.update(INSERT_PERSON, insertParams);
		System.out.println("person is inserted..." + person);

	}

}
