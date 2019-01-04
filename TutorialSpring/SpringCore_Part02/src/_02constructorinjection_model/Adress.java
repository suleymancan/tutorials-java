package _02constructorinjection_model;

public class Adress {

	private String city;
	private String street;
	
	
	public Adress(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}


	@Override
	public String toString() {
		return "Adress [city=" + city + ", street=" + street + "]";
	}

	
}
