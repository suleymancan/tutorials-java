package _01hellojsf;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "glassfishBean")
@SessionScoped
// @Named kullandigimizda
// javax.faces.bean.SessionScoped; yerine
// javax.enterprise.context.SessionScoped; kullanmamiz gereklidir.

// Named kullanıldıgında Serializable implements edilmelidir.
public class HelloGlashFishBean implements Serializable {

	private String name;
	private String password;

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
