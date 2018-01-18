package _02constructorinjection_model;

public class ConstructorConfuse {

	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ConstructorConfuse(String name) {
		super();
		System.out.println("String!");
		this.name = name;
	}
	public ConstructorConfuse(int age) {
		super();
		System.out.println("int!");
		this.age = age;
	}
	@Override
	public String toString() {
		return "ConstructorConfuse [name=" + name + ", age=" + age + "]";
	}
	
	
	
	
}
