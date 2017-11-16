package _01pageredirect;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//POJO -> plain old java object -> private property/instance degiskenler, public getter/setter ve no-arg yapılandırıcı
// bu yapıdaki class'lar pojo adını alır. 

// bean -> bean kavramıda bir bakıma pojo oluyor. framework tarafından yönetilirler. 
//ManagedBean, jsf tarafından kullanılan, yönetilen, ulaşılan java beanleridir. 
@ManagedBean // javax.faces.bean
@SessionScoped

public class PersonBean {

	private String name;
	private String password;

	public PersonBean() {
		super();
	}

	public PersonBean(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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
