package _01jdbcprogrammatic.transaction.model;

public class Person {

	private int id;
	private String name;
	private String surname;
	private int birthYear;
	// Person HAS-A Adress
	private Adress adress;

	public Person() {
		super();
	}

	public Person(int id, String name, String surname, int birthYear) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthYear = birthYear;

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

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", birthYear=" + birthYear + ", adress="
				+ adress + "]";
	}

}
