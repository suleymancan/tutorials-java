package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Department {

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	@Id
	@TableGenerator(name = "dept_gen")
	@GeneratedValue(generator = "dept_gen")

	@Column(name = "dept_id")
	private int id;
	private String name;

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department() {
		super();
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

}
