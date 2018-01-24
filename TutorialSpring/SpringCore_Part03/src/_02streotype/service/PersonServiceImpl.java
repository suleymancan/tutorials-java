package _02streotype.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import _02streotype.dao.PersonDAO;
import _02streotype.model.Person;

//default ismi personServiceImpl
@Service(value = "pService")
public class PersonServiceImpl implements PersonService {

	// buradaki objeyi spring bizim için oluşturup, bind edecek.
	// autowired kullandıgımızda setter/getter'a ihtiyac yoktur.
	@Autowired
	private PersonDAO personDAO;

	@Override
	public void insertPerson(Person person) {
		// TODO Auto-generated method stub
		System.out.println("PersonServiceImpl#insertPerson");
		personDAO.insertPerson(person);
	}

}
