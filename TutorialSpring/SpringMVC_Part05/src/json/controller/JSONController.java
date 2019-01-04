/**
 * 
 */
package json.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import json.model.Person;

/**
 * @author suleymancan Jun 2, 2018
 */
@Controller
public class JSONController {

	@RequestMapping("/getPerson")
	@ResponseBody
	public Person getPerson() {
		return new Person("1", "Süleyman", "Can", "1995");

	}

	@RequestMapping("/getPersonList")
	@ResponseBody
	public List<Person> getPersonList() {
		Person p1 = new Person("1", "Süleyman", "Can", "1995");
		Person p2 = new Person("2", "Nazlisu", "Can", "2010");
		Person p3 = new Person("3", "Mehmet Ali", "Can", "1999");

		List<Person> personList = new ArrayList<Person>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		return personList;
	}
}
