package Singleton;

class CustumChackedExceptionMain extends Exception {

	public CustumChackedExceptionMain(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

public class CustumChackedException {
	public static void main(String[] args) {
		try {
			throw new CustumChackedExceptionMain("raso");
		} catch (CustumChackedExceptionMain e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}