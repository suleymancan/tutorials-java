package _02dynamicnavigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "dynamicNavigationBean")
@SessionScoped
public class DynamicNavigationBean {

	private String name;
	private String password;

	private int counter = 0;
	private boolean locked = false;

	public String login() {
		if (name.equals("vayorebl") && password.equals("2327")) {
			counter = 0;
			locked = false;
			return "success";
		}
		counter++;
		if (locked) {
			return "locked";
		}
		return "failure";
	}

	public String checkCounter() {
		if (counter > 3) {
			locked = true;
			return "locked";

		} else
			return "retry";
	}

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

}
