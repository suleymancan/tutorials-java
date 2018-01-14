package _01.coupled.model;

public class Car {

	// CAR HAS-A TIRE
	// Bu kod bir coupled koddur. (new anahtar kelimesiyle coupled hale geldi.)
	private Tire tire;

	public Car() {
		// coupled(bağımlı/baglı/yapısık)
		tire = new Tire();
	}

	public void go() {
		tire.useTire();
	}
}
