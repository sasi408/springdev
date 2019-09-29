package Singleton;

class CustumUnChackedExceptionMain extends RuntimeException {

	public CustumUnChackedExceptionMain(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}

public class CustumUnChackedException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		throw new CustumUnChackedExceptionMain("unchacked Exception");
	}

}
