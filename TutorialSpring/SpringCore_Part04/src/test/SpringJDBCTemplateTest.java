package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonJDBCTemplateDAO;
import dao.PersonJDBCTemplateDAOImpl;
import model.Person;

public class SpringJDBCTemplateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.jdbctemplate.xml");
		PersonJDBCTemplateDAO dao = context.getBean(PersonJDBCTemplateDAOImpl.class);
		Person person = new Person("süleyman", "can", 1995);
		dao.insertPerson(person);
	}
}
