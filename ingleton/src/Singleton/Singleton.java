package Singleton;

public class Singleton {
	private static Singleton singleton;
	private Singleton() {
		}
	/*
	public static synchronized Singleton getInstance() 
    { 
        if (singleton==null) 
        	singleton = new Singleton(); 
        return singleton; 
    } 
    */
	public static Singleton getIntance(){
		if (singleton==null) {
			singleton=new Singleton();
			return singleton;
		}
		return singleton;
	}
}
