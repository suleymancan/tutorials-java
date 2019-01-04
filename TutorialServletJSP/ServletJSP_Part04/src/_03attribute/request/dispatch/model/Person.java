package _03attribute.request.dispatch.model;

public class Person {

	private String name; 
	private String surname; 
	//getter ve setterlarını oluşturdum. (ALT+SHİFT+S)
	//yapıcılarını oluşturdum.
	public String getName() {
		return name;
	}
	public Person(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
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
	
}
