package _02jpadeclarative.transaction.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	private int id;
	private String name;
	private String surname;

	@OneToOne
	private Adress adress;

	public Customer() {
		super();
	}

	public Customer(int id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", surname=" + surname + ", adress=" + adress + "]";
	}

}
