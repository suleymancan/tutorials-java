package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Phone {

	@Id
	@TableGenerator(name = "phon_gen")
	@GeneratedValue(generator = "phon_gen")
	@Column(name = "phon_gen")
	private int id;
	private String number;
	@Enumerated(EnumType.STRING)
	private PhoneType phoneType;

	public Phone() {
		super();
	}

	public Phone(String number, PhoneType phoneType) {
		super();
		this.number = number;
		this.phoneType = phoneType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public PhoneType getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(PhoneType phoneType) {
		this.phoneType = phoneType;
	}

}
