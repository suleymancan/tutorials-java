package _03springaop.service;

public class Validator {

	public void validateAge(int age) throws Exception {
		if (age < 0) {
			throw new ArithmeticException("not valid age");
		} else {
			System.out.println("it is valid age");
		}
	}

	public int parseAge(String age) {
		return Integer.valueOf(age);
	}

	public void throwRunTimeException() {
		throw new RuntimeException();
	}
}
