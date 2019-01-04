package _03.spring.model;
public class Car implements Vehicle {
	// decoupled
	private Wheel wheel;
	@Override
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
	@Override
	public void go() {
		wheel.useTire();
	}
}
