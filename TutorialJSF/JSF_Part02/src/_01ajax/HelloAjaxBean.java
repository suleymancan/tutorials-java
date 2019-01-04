package _01ajax;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloAjaxBean {

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

	// burada bir metot yazıp, o metodu çağıracağım. Butona bastığımızda sayfanın
	// bir kısmını render edecegim.
	// Ajax mantığı, sayfanın belli bir bölümünü render etmek.

	public String getGreeting() {
		return "hosgeldin!" + name;
	}

}
