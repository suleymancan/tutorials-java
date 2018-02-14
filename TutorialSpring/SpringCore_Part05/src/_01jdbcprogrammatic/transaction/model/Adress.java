package _01jdbcprogrammatic.transaction.model;

public class Adress {
	private int adressId;
	private String street;
	private String zipcode;
	private String city;

	public Adress() {
		super();
	}

	public Adress(int adressId, String street, String zipcode, String city) {
		super();
		this.adressId = adressId;
		this.street = street;
		this.zipcode = zipcode;
		this.city = city;
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Adress [adressId=" + adressId + ", street=" + street + ", zipcode=" + zipcode + ", city=" + city + "]";
	}

}
