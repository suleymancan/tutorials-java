package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonDAONamedJDBCTemplate;
import dao.PersonDAONamedJDBCTemplateImpl;
import model.Person;

public class SpringNamedJDBCTemplateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.namedjdbctemplate.xml");

		PersonDAONamedJDBCTemplate dao = context.getBean(PersonDAONamedJDBCTemplateImpl.class);
		Person person1 = new Person("Mehmet Ali", "Can", 1999);

		dao.insertPerson(person1);
		dao.getAllPerson();

		Person personFound = dao.getPersonById(4);

	}
}
