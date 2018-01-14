package _02.decoupled.model;
public class Car implements Vehicle {
	// decoupled
	private Wheel whell;
	@Override
	public void setWeel(Wheel wheel) {
		this.whell = wheel;
	}
	@Override
	public void go() {
		whell.useTire();
	}
}
