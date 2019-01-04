package _02streotype.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02streotype.model.Person;
import _02streotype.service.PersonService;
import _02streotype.service.PersonServiceImpl;

public class StreotypeTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("02.stereotype.xml");

		PersonService personService = context.getBean("pService", PersonServiceImpl.class);

		Person person = new Person();
		person.setName("Nazlisu");
		person.setSurname("Can");
		personService.insertPerson(person);

	}
}
