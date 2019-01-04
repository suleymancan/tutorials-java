package _05expressionlanguage;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "ellangBean")
@SessionScoped

public class ExpressionLanguageBean {
	private String key;
	private String value;
	private String selectedFramework;
	private Map<String, Object> frameworkMap;

	@PostConstruct // ilgili bean olustuktan sonra calisacak.
	public void init() {

		// bu kısımda datayı veritabanından cekip koyabiliriz.
		// bu örnekte manuel ayarladım.
		frameworkMap = new LinkedHashMap<String, Object>();
		frameworkMap.put("Servlet", "Servlet");
		frameworkMap.put("JSP", "JSP");
		frameworkMap.put("JSF", "JSF");
	}

	public void addFramework(String key, String value) {
		if (key != "" && value != "") {
			frameworkMap.put(key, value);
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSelectedFramework() {
		return selectedFramework;
	}

	public void setSelectedFramework(String selectedFramework) {
		this.selectedFramework = selectedFramework;
	}

	public Map<String, Object> getFrameworkMap() {
		return frameworkMap;
	}

	public void setFrameworkMap(Map<String, Object> frameworkMap) {
		this.frameworkMap = frameworkMap;
	}

}
