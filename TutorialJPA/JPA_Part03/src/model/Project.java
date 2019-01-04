package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class Project {

	@Id
	@TableGenerator(name = "proj_gen")
	@GeneratedValue(generator = "proj_gen")

	@Column(name = "proj_id")
	private int id;
	private String name;

	public Project() {
		super();
	}

	public Project(String name) {
		super();
		this.name = name;
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
