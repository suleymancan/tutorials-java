package _03collectioninjection_model;

import java.util.List;
import java.util.Map;

public class CollectionInjectionModel {

	private List<String> nameList;
	private List<Student> studentList;
	private Map<String, Integer> keyValueMap;

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Map<String, Integer> getKeyValueMap() {
		return keyValueMap;
	}

	public void setKeyValueMap(Map<String, Integer> keyValueMap) {
		this.keyValueMap = keyValueMap;
	}

	@Override
	public String toString() {
		return "CollectionInjectionModel [nameList=" + nameList + ", studentList=" + studentList + ", keyValueMap="
				+ keyValueMap + "]";
	}

}
