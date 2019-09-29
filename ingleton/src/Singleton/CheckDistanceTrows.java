package Singleton;

public class CheckDistanceTrows {

	void calc() throws ArithmeticException {
		int c = 100 / 0;
	}
}

class Demo {
	public static void main(String args[]) {
		CheckDistanceTrows t = new CheckDistanceTrows();
		try {
			t.calc();
		} catch (Exception e) {
			System.out.println(" Exception handled.... ");
		}
	}
}
