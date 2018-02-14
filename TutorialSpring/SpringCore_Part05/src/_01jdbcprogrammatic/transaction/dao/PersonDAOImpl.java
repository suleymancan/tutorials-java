package _01jdbcprogrammatic.transaction.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import _01jdbcprogrammatic.transaction.model.Adress;
import _01jdbcprogrammatic.transaction.model.Person;

public class PersonDAOImpl implements PersonDAO {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	// cesitli implementasyounları var: JDBC için DataSource transaction manager,
	// hibernate icin, jpa icin, jta icin...
	private PlatformTransactionManager transactionManager;

	private final static String INSERT_PERSON = "insert into person (id, name, surname, birthYear) values (:id, :name, :surname, :birthYear)";
	private final static String INSERT_ADRESS = "insert into adress (adressId, street, zipcode, city) values (:adressId, :street, :zipcode, :city)";
	private final static String SET_PERSON_ADRESS = "update person set adressId=:adressId where id=:id";

	// setter Injection
	public void setDataSource(DataSource dataSource) {
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	// setter Injection
	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	private TransactionStatus getTransactionStatus() {
		TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
		TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
		return status;
	}

	@Override
	public void insert(Person person) {
		TransactionStatus status = getTransactionStatus();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", person.getId());
		params.put("name", person.getName());
		params.put("surname", person.getSurname());
		params.put("birthYear", person.getBirthYear());

		try {

			namedParameterJdbcTemplate.update(INSERT_PERSON, params);
			System.out.println("Person is inserted..." + person);

			insertAdress(person.getAdress());
			updatePersonAdress(person.getId(), person.getAdress().getAdressId());
			System.out.println("person adress inserted...");
			// programmatic transaction icin
			// person tablosuna kayıt attım, adress tablosuna kayıt attım son olarakta
			// person'un adress'ini ekledim.

			// commit
			transactionManager.commit(status);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("rollback...");
			// herhangi bir problemde tüm islemler geri alınacak.
			transactionManager.rollback(status);
		}

	}

	@Override
	public void insertAdress(Adress adress) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("adressId", adress.getAdressId());
		params.put("street", adress.getStreet());
		params.put("zipcode", adress.getZipcode());
		params.put("city", adress.getCity());
		namedParameterJdbcTemplate.update(INSERT_ADRESS, params);
		System.out.println("adress is inserted" + adress);

	}

	@Override
	public void updatePersonAdress(int id, int adressId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("adressId", adressId);
		namedParameterJdbcTemplate.update(SET_PERSON_ADRESS, params);

	}

}
