package model;

public class MyMethod {
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethod(String name, MyReturnM type) {
		methodName = name;
		methodType = type;
	}
	
	public MyMethod(String name, MyVoidM type) {
		methodName = name;
		methodType = type;
	}
}
