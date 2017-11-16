package _01staticnavigation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigationBean")
@SessionScoped
public class StaticNavigationBean {

	public String goToPage3() {
		return "page3";
	}
}
