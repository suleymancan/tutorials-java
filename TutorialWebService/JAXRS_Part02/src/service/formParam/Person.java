/**
 * 
 */
package service.formParam;

import javax.ws.rs.FormParam;

/**
 * @author suleymancan Jun 14, 2018
 */
public class Person {
	@FormParam("name")
	String name;
	@FormParam("surname")
	String surname;

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
		return "Person [name=" + name + ", surname=" + surname + "]";
	}

}
