package _01autowired.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {

	private String name;
	private String surname;

	// onceki örneklerde xml konfigürasyonu üzerinden beanleri baglıyordum. ref ile
	// vs.
	// bunu autowired ile otomatik yapacagim.
	// bir de xml yaklasimi ile autowired var.
	@Autowired
	@Qualifier(value = "adress1")
	private Adress adress;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", adress=" + adress + "]";
	}

}
