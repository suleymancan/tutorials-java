package _02.decoupled.test;
import _02.decoupled.model.Car;
import _02.decoupled.model.GoodYear;
import _02.decoupled.model.Lassa;
import _02.decoupled.model.Vehicle;
import _02.decoupled.model.Wheel;
public class DecoupledTest {
	public static void main(String[] args) {
		Vehicle car = new Car();
		Wheel lassa= new Lassa();		
		car.setWeel(lassa);
		car.go();
		Wheel goodYear = new GoodYear();
		car.setWeel(goodYear);
		car.go();
	}
}
