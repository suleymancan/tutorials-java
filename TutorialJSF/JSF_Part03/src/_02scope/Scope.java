package _02scope;

//import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="requestBean")
@RequestScoped
//@ApplicationScoped
//@SessionScoped
public class Scope {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getHashCode() {
		
		return super.hashCode();
	}
	
	
}
