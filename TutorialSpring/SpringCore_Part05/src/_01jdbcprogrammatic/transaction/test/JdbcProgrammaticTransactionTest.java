package _01jdbcprogrammatic.transaction.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01jdbcprogrammatic.transaction.dao.PersonDAO;
import _01jdbcprogrammatic.transaction.dao.PersonDAOImpl;
import _01jdbcprogrammatic.transaction.model.Adress;
import _01jdbcprogrammatic.transaction.model.Person;

public class JdbcProgrammaticTransactionTest {

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("jdbc.programmatic.transaction.xml");
		PersonDAO dao = context.getBean(PersonDAOImpl.class);

		Person person = new Person(1, "Süleyman", "Can", 1995);
		Adress adress = new Adress(100, "Caydacira", "23200", "Elazig");

		person.setAdress(adress);

		dao.insert(person);

		// hatalı, zipcode.
		Person person2 = new Person(2, "Nazlisu", "Can", 2011);
		Adress adress2 = new Adress(101, "Kolejtepe", "throw exception!", "Gaziantep");

		person2.setAdress(adress2);
		dao.insert(person2);

		
		

	}

}
