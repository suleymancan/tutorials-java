package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonDAOJPA;
import dao.PersonDAOJPAImpl;
import model.Person;

public class SpringJPATest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jpa.xml");

		PersonDAOJPA dao = context.getBean(PersonDAOJPAImpl.class);

		Person p1 = new Person("Nazlisu", "Can", 2010);
		Person p2 = new Person("Kıymet", "Can", 1972);
		Person p3 = new Person("Haci", "Can", 1969);
		dao.insert(p1);
		dao.insert(p2);
		dao.insert(p3);
	}
}
