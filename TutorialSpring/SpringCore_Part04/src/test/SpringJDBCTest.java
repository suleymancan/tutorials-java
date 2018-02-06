package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonJDBCDAO;
import dao.PersonJDBCDAOImpl;
import model.Person;

public class SpringJDBCTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.jdbc.xml");
		PersonJDBCDAO jdbcdao = context.getBean(PersonJDBCDAOImpl.class);
		Person person = new Person("test", "test surname", 1995);
		jdbcdao.insert(person);

	}
}
