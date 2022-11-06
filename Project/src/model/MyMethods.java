package model;

public class MyMethods{	
	String methodName;
	
	/* I made an abstract class to help 
	* distinguishing method return type
	*/
	MethodType methodType; 
	
	
	public MyMethods(String name, MyReturnMethod type) {
		methodName = name;
		methodType = type;
	}
	
	public MyMethods(String name, MyVoidMethod type) {
		methodName = name;
		methodType = type;
	}
	
	@Override
	public String toString() {
		return "mymethod " + methodName + " "; 
	}
}
 
/*
 	String methodName;
	MethodType methodType; 
	
	
	public MyMethod(String name, MethodType type) {
		methodName = name;
		methodType = type;
	}

	@Override
	public String toString() {
		return "mymethod " + methodName + " " + methodType.toString(); 
	}
*/
