package Singleton;

public class CheckDistance {
	int distance;

	public CheckDistance(int distance) {
		this.distance = distance;
		if (distance < 0) {
			throw new ArithmeticException("Please enter valid distance...");
		} else {
			System.out.println("This is valid distance.");
		}
	}

	public static void main(String args[]) {
		CheckDistance d = new CheckDistance(-10);
	}

}
