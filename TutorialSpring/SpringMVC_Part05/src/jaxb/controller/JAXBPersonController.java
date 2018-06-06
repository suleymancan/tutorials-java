/**
 * 
 */
package jaxb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jaxb.model.Person;
import jaxb.model.PersonList;

/**
 * @author suleymancan Jun 2, 2018
 */

@Controller
public class JAXBPersonController {

	@RequestMapping("/getPersonXML")
	@ResponseBody
	public Person getPersonXML() {
		return new Person("1", "Süleyman", "Can", "1995");

	}

	@RequestMapping("/getPersonListXML")
	@ResponseBody
	public PersonList getPersonListXML() {
		Person p1 = new Person("1", "Süleyman", "Can", "1995");
		Person p2 = new Person("2", "Nazlisu", "Can", "2010");
		Person p3 = new Person("3", "Mehmet Ali", "Can", "1999");
		List<Person> persons = new ArrayList<Person>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);

		PersonList personList = new PersonList(persons);
		return personList;
	}

}
