package Singleton;

class MainE extends Exception {

	public MainE(String s) {
		// Call constructor of parent Exception
		super(s);
	}
}

public class Main {
	// Driver Program
	public static void main(String args[]) {
		try {
			// Throw an object of user defined exception
			throw new MainE("GeeksGeeks");
		} catch (MainE ex) {
			System.out.println("Caught");

			// Print the message from MyException object
			System.out.println(ex.getMessage());
		}
	}
}