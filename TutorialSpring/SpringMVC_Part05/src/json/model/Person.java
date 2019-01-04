/**
 * 
 */
package json.model;

/**
 * @author suleymancan Jun 2, 2018
 */
public class Person {

	private String id;
	private String name;
	private String surname;
	private String birthday;

	public Person(String id, String name, String surname, String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
