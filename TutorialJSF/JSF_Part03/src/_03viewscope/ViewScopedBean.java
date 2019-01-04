package _03viewscope;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped

// ViewScope, serializable olmalı.
public class ViewScopedBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private int counter;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCounter() {
		return ++counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getHashCode() {
		return super.hashCode();
	}

}
